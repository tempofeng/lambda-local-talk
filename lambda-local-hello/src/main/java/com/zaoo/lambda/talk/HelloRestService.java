package com.zaoo.lambda.talk;

import com.zaoo.lambda.LambdaLocal;
import com.zaoo.lambda.rest.*;

@SuppressWarnings("unused")
@LambdaLocal("/helloRestService")
@CrossOrigin
public class HelloRestService extends AbstractLambdaRestService {
    @RestMethod(httpMethod = HttpMethod.GET, path = "/hello1")
    public Greeting hello1(@RestParam("firstName") String firstName,
                           @RestParam("lastName") String lastName) {
        String message = String.format("Hello %s, %s.", firstName, lastName);
        return new Greeting(message);
    }

    public static class Greeting {
        public String message;

        public Greeting(String message) {
            this.message = message;
        }
    }

    @RestMethod(httpMethod = HttpMethod.GET, path = "/hello2")
    public Greeting hello2(@RestParam("name") Name name) {
        String message = String.format("Hello %s, %s.", name.firstName, name.lastName);
        return new Greeting(message);
    }

    public static class Name {
        public String firstName;
        public String lastName;
    }

    @RestMethod(httpMethod = HttpMethod.POST, path = "/hello3")
    public Greeting hello3(@RestBody Name name) {
        String message = String.format("Hello %s, %s.", name.firstName, name.lastName);
        return new Greeting(message);
    }

    @RestMethod(httpMethod = HttpMethod.GET, path = "/hello4/{firstName}/{lastName}")
    public Greeting hello4(@RestPath("firstName") String firstName,
                           @RestPath("lastName") String lastName) {
        String message = String.format("Hello %s, %s.", firstName, lastName);
        return new Greeting(message);
    }
}
