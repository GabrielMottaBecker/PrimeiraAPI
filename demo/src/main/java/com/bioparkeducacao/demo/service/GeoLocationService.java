package com.bioparkeducacao.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeoLocationService {

    public Map<String, String> getLocation() {
        String url = "http://ip-api.com/json/";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        Map<String, String> location = new HashMap<>();
        if (response != null) {
            location.put("cidade", (String) response.get("city"));
            location.put("estado", (String) response.get("regionName"));
            location.put("pais", (String) response.get("country"));
            location.put("latitude", String.valueOf(response.get("lat")));
            location.put("longitude", String.valueOf(response.get("lon")));
        } else {
            location.put("cidade", "Desconhecido");
            location.put("estado", "Desconhecido");
            location.put("pais", "Desconhecido");
            location.put("latitude", "0");
            location.put("longitude", "0");
        }

        return location;
    }
}
