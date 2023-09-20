package com.example.microservicemiddleware.microservicemiddleware.Service;

import com.example.microservicemiddleware.microservicemiddleware.Resp.CustomerResponse;
import com.example.microservicemiddleware.microservicemiddleware.models.OTP;
import com.example.microservicemiddleware.microservicemiddleware.Resp.OTPRes;
import com.example.microservicemiddleware.microservicemiddleware.models.CustomerRequest;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service

public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public CustomerResponse callUpstreamService(CustomerRequest customerRequest) {
        String url = "http://localhost:8080/getcustomer"; // Replace with the actual URL of the upstream service
        // Make the HTTP request
        CustomerResponse response = restTemplate.postForObject(url, customerRequest, CustomerResponse.class);
        return response;
    }
    public OTPRes callotp(OTP otp) {
        OTPRes  otpRes = new OTPRes();
        otp.setNum("1234");

           try {
               String url = "http://localhost:8080/otp"; // Replace with the actual URL of the second API
               // Make the HTTP request
               otpRes=  restTemplate.postForObject(url, otp, OTPRes.class);

           }catch (Exception e){
               otpRes.setMsg(e.getMessage());
            }
       return  otpRes;
    }
}
