package com.example.microservicemiddleware.microservicemiddleware.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OTP {
    @JsonProperty("mobileNumber")
    String mobileNumber;

    public String getNum() {
        return mobileNumber;
    }

    public void setNum(String num) {
        this.mobileNumber = num;
    }
}
