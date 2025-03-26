package com.lizhengpeng.bigger.java;

import io.grpc.Context;
import io.grpc.Contexts;

public class GrpcSample {
    public static void main(String[] args) throws InterruptedException {
        Context.Key<Object> clientId = Context.key("clientId");
        Context current = Context.current();
        Context context = current.withValue(clientId, "jl==");
        context.attach();

        System.out.println("Client Id: " + clientId.get());
    }
}
