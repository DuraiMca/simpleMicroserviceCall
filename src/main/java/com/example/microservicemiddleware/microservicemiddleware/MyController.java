package com.example.microservicemiddleware.microservicemiddleware;

import com.example.microservicemiddleware.microservicemiddleware.Service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final ApiService apiService;

    public MyController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/callUpstream")
    public Object callUpstreamService() {
        Object response = apiService.callUpstreamService();
        return "Response from Upstream Service: " + response;
    }
}