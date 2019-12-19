package com.banboo.blog.aspect.model;

import java.util.Arrays;
import java.util.StringJoiner;

public class RequestLog {

    private String url;

    private String ip;

    private String classMethod;

    private Object[] args;

    public RequestLog(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RequestLog.class.getSimpleName() + "[", "]")
                .add("url='" + url + "'")
                .add("ip='" + ip + "'")
                .add("classMethod='" + classMethod + "'")
                .add("args=" + Arrays.toString(args))
                .toString();
    }
}
