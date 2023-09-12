package com.example.microservicemiddleware.microservicemiddleware;

import com.example.microservicemiddleware.microservicemiddleware.Service.ApiService;
import com.example.microservicemiddleware.microservicemiddleware.models.CustomerRequest;
import org.springframework.web.bind.annotation.GetMapping;
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
        Object response = apiService.callUpstreamService(RequestBodyreq);
        return "Response from Upstream Service: " + response;
    }
}