/*
 * Copyright Medical Research Council (c) 2022.
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
import java.util.Collection;
import java.util.List;
import uk.ac.mrc.har.trackerclient.entities.Centre;
import uk.ac.mrc.har.trackerclient.entities.TrackerExperiment;
import uk.ac.mrc.har.trackerclient.entities.TrackerSpecimen;

public class Main {

    // Change this to api.mousephenotype.org/tracker when we go live.
    public static String restURL = "https://api.mousephenotype.org/tracker/";
//    public static String restURL = "http://localhost:5678/";

    /**
     * 
     * @param <T> A class with a corresponding ItemType
     * @param itemType The corresponding ItemType
     * @param id The id of the item you want.
     * @return An instance of the requested item
     * @throws IOException
     */
    public static <T> T get(ItemType itemType, int id) throws IOException {
        String json = HttpClient.getJSON(restURL + itemType.name().toLowerCase() + "/" + Integer.toString(id));
        return (T) JacksonConverter.fromJSON(json, itemType.getClazz());
    }
    /**
     * 
     * @param <T> A class with a corresponding ItemType
     * @param itemType The corresponding ItemType
     * @param ids A collection of the IDs you want
     * @return A collection of instances of the requested item
     * @throws IOException 
     */
    public static <T> Collection<T> post(ItemType itemType, Collection<Integer> ids) throws IOException {
        HttpClient.MyResponse rtns = HttpClient.postJSON(restURL + itemType.name().toLowerCase() + "/multiple", JacksonConverter.toJSON(ids));
        List<T> itemList = (List<T>) JacksonConverter.fromJSON_Collection(rtns.getBody(), itemType.getClazz());
        return itemList;
    }
    
    /**
     * Lists possible 'item' types.
     */
    public enum ItemType implements ItemInterface {
        CENTRE {
            @Override
            public Class getClazz() {
                return Centre.class;
            }
        },
        TRACKERSPECIMEN {
            @Override
            public Class getClazz() {
                return TrackerSpecimen.class;
            }
        },
        TRACKEREXPERIMENT {
            @Override
            public Class getClazz() {
                return TrackerExperiment.class;
            }
        }
        ;
    }

    /**
     * Used only by the ItemType enum
     */
    interface ItemInterface {
        public Class getClazz();
    }
}
