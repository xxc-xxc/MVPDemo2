package com.example.xxc.mvpdemo2.bean;

import java.io.Serializable;

public class BaseBean<T> implements Serializable {
    private String reason;
    private int code;
    private T result;

    public BaseBean(String reason, int code) {
        this.reason = reason;
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}