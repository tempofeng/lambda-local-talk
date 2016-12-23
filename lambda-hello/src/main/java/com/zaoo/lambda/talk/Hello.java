package com.zaoo.lambda.talk;

import com.amazonaws.services.lambda.runtime.Context;

@SuppressWarnings("unused")
public class Hello {
    public String myHandler(String name, Context context) {
        return String.format("Hello %s.", name);
    }
}
