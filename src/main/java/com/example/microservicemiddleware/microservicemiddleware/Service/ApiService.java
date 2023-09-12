package com.example.microservicemiddleware.microservicemiddleware.Service;

import com.example.microservicemiddleware.microservicemiddleware.models.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Object callUpstreamService(CustomerRequest customerRequest) {
        String url = "http://localhost:8080/getcustomer"; // Replace with the actual URL of the upstream service
        // Make the HTTP request
        Object response = restTemplate.postForObject(url, customerRequest, String.class);
        return response;
    }
    public Object callotp() {
        String url = "localhost:8080/otp"; // Replace with the actual URL of the second API
        // Make the HTTP request
        Object response = restTemplate.getForObject(url, Object.class);
        return response;
    }
}
