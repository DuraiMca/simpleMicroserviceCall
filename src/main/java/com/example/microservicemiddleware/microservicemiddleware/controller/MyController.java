package com.example.microservicemiddleware.microservicemiddleware.controller;

import com.example.microservicemiddleware.microservicemiddleware.Resp.CustomerResponse;
import com.example.microservicemiddleware.microservicemiddleware.Service.ApiService;
import com.example.microservicemiddleware.microservicemiddleware.models.CustomerRequest;
import com.example.microservicemiddleware.microservicemiddleware.models.OTP;
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
    public Object callUpstreamService(@RequestBody CustomerRequest RequestBodyreq) {
        CustomerResponse response = apiService.callUpstreamService(RequestBodyreq);
        if (response.getGetCustomer360SummaryRep().getMsgBdy().getCustDtlsRp() != null) {
            OTP otp=new OTP();
            otp.setNum("1234");
            Object res = apiService.callotp(otp);
            return res;
        }
        return "Response from Upstream Service: " + "ERROR";
    }
}