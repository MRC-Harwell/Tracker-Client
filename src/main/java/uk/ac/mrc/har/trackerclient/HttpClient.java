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
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

    public static MyResponse post(String url, String cType, String bodyData) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost put = new HttpPost(url);
        put.setHeader("Content-Type", cType);
        StringEntity params = new StringEntity(bodyData, "UTF-8");
        put.setEntity(params);

        System.out.println("Executing request " + put.getRequestLine());

        // Create a custom response handler
        ResponseHandler<MyResponse> responseHandler = (final HttpResponse response) -> {
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            return new MyResponse(status, (entity != null ? EntityUtils.toString(entity) : createErrorMessage("No entity returned! ")));
        };

        MyResponse responseBody = httpclient.execute(put, responseHandler);
        System.out.println("----------------------------------------");
        return responseBody;

    }

    public static MyResponse postJSON(String url, String jsonData) throws IOException {
        return post(url, "application/json", jsonData);
    }

    public static MyResponse postSearch(String bodyData) throws IOException {
        return post(Main.restURL + "search", "application/json", bodyData);
    }

    public static String getJSON(String url) throws IOException {
        return getJSON(url, null);
    }

    /**
     * Boilerplate code from HttpComponent lib.
     *
     * @param url
     * @param headers
     * @return
     */
    public static String getJSON(String url, Map<String, String> headers) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(url);

        if (headers != null) {
            for (String h : headers.keySet()) {
                httpget.setHeader(h, headers.get(h));
            }
        }
        System.out.println("Executing request " + httpget.getRequestLine());

        // Create a custom response handler
        ResponseHandler<String> responseHandler = (final HttpResponse response) -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : createErrorMessage("No entity returned! ");
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };

        String responseBody = httpclient.execute(httpget, responseHandler);
        return responseBody;
    }

    public static String createErrorMessage(String s) {
        return "{\"message\": \"" + s + "\"}";
    }

    /**
     * Simple wrapper for responses.
     */
    public static class MyResponse {

        int code;
        String body;

        public MyResponse(int code, String body) {
            this.code = code;
            this.body = body;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

    }
}
