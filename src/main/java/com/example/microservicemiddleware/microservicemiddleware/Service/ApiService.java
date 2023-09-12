package com.example.microservicemiddleware.microservicemiddleware.Service;

import com.example.microservicemiddleware.microservicemiddleware.CustomerResponse;
import com.example.microservicemiddleware.microservicemiddleware.OTP;
import com.example.microservicemiddleware.microservicemiddleware.OTPRes;
import com.example.microservicemiddleware.microservicemiddleware.models.CustomerRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public Object callotp(OTP otp) {
        String url = "http://localhost:8080/otp"; // Replace with the actual URL of the second API
        // Make the HTTP request
        OTPRes response = restTemplate.postForObject(url,otp, OTPRes.class);
        return response;
    }
}
