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
import uk.ac.mrc.har.trackerclient.entities.Log;

public class LineProcedure {

    private String pipeline;
    private String createdDate;
    private Integer statusId;
    private Integer created;
    private Integer id;
    private String procedure;
    private String colony;
    private String sequenceId;
    private String phenotypingCentre;
    private Integer xmlId;
    private Collection<Log> logs;
    private String status;

    public String getPipeline() {
        return pipeline;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(String sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getPhenotypingCentre() {
        return phenotypingCentre;
    }

    public void setPhenotypingCentre(String phenotypingCentre) {
        this.phenotypingCentre = phenotypingCentre;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public Integer getCreated() {
        return created;
    }

    public Integer getId() {
        return id;
    }

    public String getProcedure() {
        return procedure;
    }

    public Integer getXmlId() {
        return xmlId;
    }

    public Collection<Log> getLogs() {
        return logs;
    }

    public String getStatus() {
        return status;
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

    public void setCreated(Integer created) {
        this.created = created;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public void setXmlId(Integer xmlId) {
        this.xmlId = xmlId;
    }

    public void setLogs(Collection<Log> logs) {
        this.logs = logs;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LineProcedure{" + "pipeline=" + pipeline + ", createdDate=" + createdDate + ", statusId=" + statusId + ", created=" + created + ", id=" + id + ", procedure=" + procedure + ", colony=" + colony + ", sequenceId=" + sequenceId + ", phenotypingCentre=" + phenotypingCentre + ", xmlId=" + xmlId + ", logs=" + logs + ", status=" + status + '}';
    }

}
