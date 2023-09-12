package com.example.microservicemiddleware.microservicemiddleware.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


    public class CustomerRequest {
        private String cstId;

        public String getCstId() {
            return cstId;
        }

        public void setCstId(String cstId) {
            this.cstId = cstId;
        }
        @JsonCreator
        public CustomerRequest(@JsonProperty("cstId") String cstId) {
            this.cstId = cstId;
        }
// getters and setters
    }

