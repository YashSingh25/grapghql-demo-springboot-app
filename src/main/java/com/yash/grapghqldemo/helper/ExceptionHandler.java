package com.yash.grapghqldemo.helper;

public class ExceptionHandler {

    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource not found!!");
    }
}
