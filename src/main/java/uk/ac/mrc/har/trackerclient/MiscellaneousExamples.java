/*
 * Copyright Medical Research Council (c) 2018.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package uk.ac.mrc.har.trackerclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static uk.ac.mrc.har.trackerclient.Main.restURL;
import uk.ac.mrc.har.trackerclient.entities.LineProcedure;
import uk.ac.mrc.har.trackerclient.entities.TrackerExperiment;
import uk.ac.mrc.har.trackerclient.entities.TrackerSpecimen;

/**
 * This class will contain various static methods which exist as sample
 * solutions to particular problems. They're not necessarily the most polished
 * code, but sometimes it's easier to explain with code than in plain text.
 */
public class MiscellaneousExamples {

    public static void main(String[] args) {
//        trackerExperimentFromSearchResultsExample();
        trackerSpecimenFromSearchResultsExample();
    }

    /**
     * This example uses the specimen search to retrieve a list of identifiers
     * which are then posted to get the relevant TrackerSpecimens
     */
    public static void trackerSpecimenFromSearchResultsExample() {
        try {
            String json = HttpClient.getJSON("https://api.mousephenotype.org/tracker/search/specimens?centre=Ucd&specimenId=BL3935-144");
            List<Integer> idList = JacksonConverter.fromJSON_intArray(json);
            Collection<TrackerSpecimen> aSpecList = Main.post(Main.ItemType.TRACKERSPECIMEN, idList);
            for (TrackerSpecimen ts : aSpecList) {
                System.out.println(ts);
            }
        } catch (IOException ex) {
            Logger.getLogger(MiscellaneousExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This example uses the experiment procedures search to retrieve a list of
     * identifiers which are then posted to get the relevant TrackerExperiments.
     */
    public static void trackerExperimentFromSearchResultsExample() {
        try {
            String json = HttpClient.getJSON("https://api.mousephenotype.org/tracker/search/experimentprocedures?centre=Ucd&procedure=IMPC_ALZ_001&specimenId=BL3935-144");
            List<Integer> idList = JacksonConverter.fromJSON_intArray(json);
            Collection<TrackerExperiment> anExpList = Main.post(Main.ItemType.TRACKEREXPERIMENT, idList);
            for (TrackerExperiment te : anExpList) {
                System.out.println(te);
            }
        } catch (IOException ex) {
            Logger.getLogger(MiscellaneousExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Simple GET example for trackerspecimens
     */
    public static void trackerSpecimenGetExample() {
        try {
            TrackerSpecimen aSpec = Main.get(Main.ItemType.TRACKERSPECIMEN, 3928753);
            System.out.println(aSpec);
        } catch (IOException ex) {
            Logger.getLogger(MiscellaneousExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Simple POST example for trackerspecimens
     */
    public static void trackerSpecimenPostExample() {
        try {
            ArrayList<Integer> aList = new ArrayList<>();
            aList.add(4298498);
            aList.add(3928753);
            Collection<TrackerSpecimen> aSpecList = Main.post(Main.ItemType.TRACKERSPECIMEN, aList);
            for (TrackerSpecimen aSpec : aSpecList) {
                System.out.println(aSpec);
            }
        } catch (IOException ex) {
            Logger.getLogger(MiscellaneousExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void latestFailureWithoutActiveSubmissionTest() throws IOException {
        String json = HttpClient.getJSON("http://sandbox.mousephenotype.org/trackerapi/experimentprocedures/failureswithoutactivesubmissions/J/A12142?showdetails=true");
        Collection<TrackerExperiment> exps = JacksonConverter.fromJSON_Collection(json, TrackerExperiment.class);
        Long latest = 0l;
        TrackerExperiment theLatest = null;
        for (TrackerExperiment exp : exps) {
            Long lng = exp.getCreated();
            if (lng > latest) {
                latest = lng;
                theLatest = exp;
            }
        }
        System.out.println("Latest Failure without Active Submission is");
        System.out.println(JacksonConverter.toJSON(theLatest));

    }

    public static void test_LineProcedure2() {
        try {
            String json = HttpClient.postJSON(restURL + "item/lineprocedures/multiple", "[147435,147434]").getBody();
            Collection<LineProcedure> procs = JacksonConverter.fromJSON_Collection(json, LineProcedure.class);

            for (LineProcedure aProc : procs) {
                System.out.println(aProc);
            }

        } catch (IOException ex) {
            System.out.println("Warning, unable to get the lineproc");
            ex.printStackTrace();

        }
    }

    public static LineProcedure test_LineProcedure() {
        try {
            String json = HttpClient.getJSON(restURL + "item/lineprocedures/147434");
            LineProcedure aProc = JacksonConverter.fromJSON(json, LineProcedure.class);
            System.out.println(aProc);
            return aProc;
        } catch (IOException ex) {
            System.out.println("Warning, unable to get the lineproc");
            ex.printStackTrace();
            return null;
        }
    }

    public static Map<String, Integer> media_centreCache() {
        Map<String, Integer> centreList = new HashMap<>();
        try {
            String json = HttpClient.getJSON(restURL + "centre/listfields?f=shortName&f=centreId");
            List<Object> resultList = JacksonConverter.fromJSON_objArray(json);
            for (Object o : resultList) {
                List rawCentre = (List) o;
                centreList.put(rawCentre.get(0).toString(), Integer.parseInt(rawCentre.get(1).toString()));
            }
            return centreList;
        } catch (IOException ex) {
            System.out.println("Warning, unable to get the centre map.");
            return null;
        }
    }

    /**
     * Queries the Tracker API for all the centres ILAR Codes (shortName) and
     * their corresponding imits identifiers (imitsName)
     *
     * @return A map with the ILAR code as key, the imits name as value.
     */
    public static Map<String, String> crawler_imitsLookup() {
        try {
            String json = HttpClient.getJSON(restURL + "centre/listfields?f=shortName&f=imitsName");
            Collection<List<String>> resultList = JacksonConverter.fromJSON_Collection(json, List.class);
            HashMap<String, String> aMap = new HashMap<>();
            for (List<String> l : resultList) {
                aMap.put(l.get(0), l.get(1));
            }
            return aMap;
        } catch (IOException ex) {
            Logger.getLogger(MiscellaneousExamples.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
