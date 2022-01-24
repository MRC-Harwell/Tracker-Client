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
package uk.ac.mrc.har.trackerclient.entities;

import java.util.Collection;

public class TrackerExperiment {

    private String phenotypingCentre;
    private Long created;
    private String procedure;
    private String sequenceId;
    private String pipeline;
    private String createdDate;
    private Integer statusId;
    private String specimen;
    private String dateOfExperiment;
    private Integer id;
    private Integer xmlId;
    private Collection<Object> logs;
    private String experimentName;
    private String age;
    private String status;

    public String getPhenotypingCentre() {
        return phenotypingCentre;
    }

    public Long getCreated() {
        return created;
    }

    public String getProcedure() {
        return procedure;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public String getPipeline() {
        return pipeline;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public String getSpecimen() {
        return specimen;
    }

    public String getDateOfExperiment() {
        return dateOfExperiment;
    }

    public Integer getId() {
        return id;
    }

    public Integer getXmlId() {
        return xmlId;
    }

    public Collection<Object> getLogs() {
        return logs;
    }

    public String getExperimentName() {
        return experimentName;
    }

    public String getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public void setPhenotypingCentre(String phenotypingCentre) {
        this.phenotypingCentre = phenotypingCentre;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public void setDateOfExperiment(String dateOfExperiment) {
        this.dateOfExperiment = dateOfExperiment;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setXmlId(Integer xmlId) {
        this.xmlId = xmlId;
    }

    public void setLogs(Collection<Object> logs) {
        this.logs = logs;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TrackerExperiment{" + "phenotypingCentre=" + phenotypingCentre + ", created=" + created + ", procedure=" + procedure + ", sequenceId=" + sequenceId + ", pipeline=" + pipeline + ", createdDate=" + createdDate + ", statusId=" + statusId + ", specimen=" + specimen + ", dateOfExperiment=" + dateOfExperiment + ", id=" + id + ", xmlId=" + xmlId + ", logs=" + logs + ", experimentName=" + experimentName + ", age=" + age + ", status=" + status + '}';
    }
    
}
