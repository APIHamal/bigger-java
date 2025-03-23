package com.lizhengpeng.bigger.java;

public class ContextHolder {

    public static String TRACE_ID = "x-trace-id";
    
    public static final ThreadLocal<String> TRACE_ID_HOLDER = ThreadLocal.withInitial(() -> "EMPTY_TRACE_ID");

    public static String getTraceId() {
        return TRACE_ID_HOLDER.get();
    }

    public static void setTraceId(String traceId) {
        TRACE_ID_HOLDER.set(traceId);
    }

    public static void remove() {
        TRACE_ID_HOLDER.remove();
    }

}
