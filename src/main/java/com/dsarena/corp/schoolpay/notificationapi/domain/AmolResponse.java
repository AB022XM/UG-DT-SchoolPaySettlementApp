package com.dsarena.corp.schoolpay.notificationapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AmolResponse {

    @JsonProperty("code")
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    String code;

    @JsonProperty("data")
    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    Data data;

    @JsonProperty("message")
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    @JsonProperty("sourceInfo")
    public Object getSourceInfo() {
        return this.sourceInfo;
    }

    public void setSourceInfo(Object sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    Object sourceInfo;

    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;
}
