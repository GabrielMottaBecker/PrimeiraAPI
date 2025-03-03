package com.bioparkeducacao.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeoLocationService {

    public Map<String, String> getLocation() {
        Map<String, String> location = new HashMap<>();
        location.put("cidade", "Palotina");
        location.put("estado", "Paraná");
        location.put("pais", "Brasil");
        location.put("latitude", "-24.247");
        location.put("longitude", "-53.689");

        return location;
    }
}
