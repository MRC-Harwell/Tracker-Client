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

public class TrackerSpecimen {

    private boolean isBaseline;
    private String strain;
    private String colony;
    private String phenotypingCentre;
    private Long created;
    private String sex;
    private String project;
    private String dateOfBirth;
    private String type;
    private String pipeline;
    private String createdDate;
    private String zygosity;
    private Integer statusId;
    private String specimen;
    private Integer id;
    private Integer xmlId;
    private Collection<Object> logs;
    private String status;

    public String getStrain() {
        return strain;
    }

    public String getColony() {
        return colony;
    }

    public String getPhenotypingCentre() {
        return phenotypingCentre;
    }

    public boolean isIsBaseline() {
        return isBaseline;
    }

    public void setIsBaseline(boolean isBaseline) {
        this.isBaseline = isBaseline;
    }

    
    public Long getCreated() {
        return created;
    }

    public String getSex() {
        return sex;
    }

    public String getProject() {
        return project;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public String getPipeline() {
        return pipeline;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getZygosity() {
        return zygosity;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public String getSpecimen() {
        return specimen;
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

    public String getStatus() {
        return status;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public void setPhenotypingCentre(String phenotypingCentre) {
        this.phenotypingCentre = phenotypingCentre;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setZygosity(String zygosity) {
        this.zygosity = zygosity;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
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

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TrackerSpecimen{" + "strain=" + strain + ", colony=" + colony + ", phenotypingCentre=" + phenotypingCentre + ", created=" + created + ", sex=" + sex + ", project=" + project + ", dateOfBirth=" + dateOfBirth + ", type=" + type + ", pipeline=" + pipeline + ", createdDate=" + createdDate + ", zygosity=" + zygosity + ", statusId=" + statusId + ", specimen=" + specimen + ", id=" + id + ", xmlId=" + xmlId + ", logs=" + logs + ", status=" + status + '}';
    }
    
}
