package com.example;

import java.util.UUID;

public class Greeting {

    private String id;
    private String msg;

    public Greeting(String msg) {
        this.id = UUID.randomUUID().toString();
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Greeting [msg=" + msg +"]";
    }
}
