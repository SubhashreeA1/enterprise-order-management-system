package com.eoms.order_service.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean validateToken(String token) {
        try {
            String url = "http://localhost:8081/auth/validate?token=" + token;
            restTemplate.getForObject(url, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

