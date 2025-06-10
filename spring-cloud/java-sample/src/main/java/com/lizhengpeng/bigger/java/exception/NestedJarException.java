package com.lizhengpeng.bigger.java.exception;

public class NestedJarException extends RuntimeException {

    public NestedJarException() {
        super();
    }

    public NestedJarException(String message) {
        super(message);
    }

    public NestedJarException(String message, Throwable cause) {
        super(message, cause);
    }

}
