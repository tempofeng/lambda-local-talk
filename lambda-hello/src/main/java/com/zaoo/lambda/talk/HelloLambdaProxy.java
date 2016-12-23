package com.zaoo.lambda.talk;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.Collections;
import java.util.Map;

@SuppressWarnings("unused")
public class HelloLambdaProxy {
    public LambdaProxyResponse myHandler(LambdaProxyRequest request, Context context) {
        Map<String, String> queryStringParameters = request.getQueryStringParameters();
        String greetingString = String.format("Hello %s, %s.",
                queryStringParameters.get("firstName"),
                queryStringParameters.get("lastName"));
        return new LambdaProxyResponse(200, Collections.emptyMap(), greetingString);
    }

    public static class LambdaProxyRequest {
        private Map<String, String> queryStringParameters;
        public Map<String, String> getQueryStringParameters() {
            return queryStringParameters;
        }
        public void setQueryStringParameters(Map<String, String> queryStringParameters) {
            this.queryStringParameters = queryStringParameters;
        }
    }

    public static class LambdaProxyResponse {
        private int statusCode;
        private Map<String, String> headers;
        private String body;

        public LambdaProxyResponse() {
        }
        public LambdaProxyResponse(int statusCode, Map<String, String> headers, String body) {
            this.statusCode = statusCode;
            this.headers = headers;
            this.body = body;
        }
        public int getStatusCode() {
            return statusCode;
        }
        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
        public Map<String, String> getHeaders() {
            return headers;
        }
        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }
        public String getBody() {
            return body;
        }
        public void setBody(String body) {
            this.body = body;
        }
    }
}
