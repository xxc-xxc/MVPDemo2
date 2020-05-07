package com.example.xxc.mvpdemo2.base;

public class BaseModel<T> implements Serializable {
    private String reason;
    private int code;
    private T result;

    public BaseModel(String reason, int code) {
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