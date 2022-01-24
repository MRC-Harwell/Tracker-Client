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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JacksonConverter {

    public static String toJSON(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }

    public static <T> T fromJSON(String json, Class<?> cls) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(json, cls);
    }

    public static <T> Collection<T> fromJSON_Collection(String json, Class<?> cls) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructCollectionType(Collection.class, cls);
        return mapper.readValue(json, type);
    }

    public static List<Object> fromJSON_objArray(String s) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Object>> typeRef = new TypeReference<List<Object>>() {
        };
        List<Object> map = mapper.readValue(s, typeRef);
        return map;
    }

    public static List<Integer> fromJSON_intArray(String s) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Integer>> typeRef = new TypeReference<List<Integer>>() {
        };
        List<Integer> map = mapper.readValue(s, typeRef);
        return map;
    }
}
