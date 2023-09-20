package com.example.microservicemiddleware.microservicemiddleware.Resp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTPRes {
    @JsonProperty("msg")
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
