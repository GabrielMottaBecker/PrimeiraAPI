package com.bioparkeducacao.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BioparkService {

    public String buscarDados() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://bioparkeducacao.com/";
        return restTemplate.getForObject(url, String.class);
    }
}
