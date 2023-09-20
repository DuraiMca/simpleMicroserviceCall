package com.example.microservicemiddleware.microservicemiddleware.controller;

import com.example.microservicemiddleware.microservicemiddleware.Resp.CustomerResponse;
import com.example.microservicemiddleware.microservicemiddleware.Resp.OTPRes;
import com.example.microservicemiddleware.microservicemiddleware.Service.ApiService;
import com.example.microservicemiddleware.microservicemiddleware.models.CustomerRequest;
import com.example.microservicemiddleware.microservicemiddleware.models.OTP;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final ApiService apiService;

    public MyController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/callUpstream")
    public ResponseEntity<OTPRes> callUpstreamService(@RequestBody CustomerRequest RequestBodyreq) {
        CustomerResponse response = new CustomerResponse();
        OTPRes otpRes = new OTPRes();
        OTP otp = new OTP();

        response = apiService.callUpstreamService(RequestBodyreq);

        if (response != null) {
            otp.setNum(response.getMobileNumber());
            otpRes = apiService.callotp(otp);

        }

        return ResponseEntity.ok().body(otpRes);
    }
    }


