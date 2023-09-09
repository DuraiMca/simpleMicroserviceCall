package com.example.microservicemiddleware.microservicemiddleware.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Object callUpstreamService() {
        String url = "http://localhost:8080/upstream/getID"; // Replace with the actual URL of the upstream service
        // Make the HTTP request
        Object response = restTemplate.postForObject(url, null, String.class);
        return response;
    }
}
