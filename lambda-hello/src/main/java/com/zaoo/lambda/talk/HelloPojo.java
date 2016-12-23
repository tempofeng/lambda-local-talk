package com.zaoo.lambda.talk;

import com.amazonaws.services.lambda.runtime.Context;

@SuppressWarnings("unused")
public class HelloPojo {
    public static ResponseClass myHandler(RequestClass request, Context context) {
        String greetingString = String.format("Hello %s, %s.", request.getFirstName(), request.getLastName());
        return new ResponseClass(greetingString);
    }

    public static class RequestClass {
        String firstName;
        String lastName;

        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public RequestClass(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public RequestClass() {
        }
    }

    public static class ResponseClass {
        String greetings;

        public String getGreetings() {
            return greetings;
        }
        public void setGreetings(String greetings) {
            this.greetings = greetings;
        }
        public ResponseClass(String greetings) {
            this.greetings = greetings;
        }
        public ResponseClass() {
        }
    }
}
