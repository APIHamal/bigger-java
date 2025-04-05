package com.lizhengpeng.bigger.java;

public class GatewayException extends RuntimeException {

    public GatewayException(String message) {
        super(message);
    }

    public GatewayException(String message, Exception e) {
        super(message, e);
    }

}
