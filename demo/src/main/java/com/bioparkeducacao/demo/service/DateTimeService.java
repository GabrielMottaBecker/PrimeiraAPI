package com.bioparkeducacao.demo.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class DateTimeService {

    public Map<String, String> getDateTime() {
        Map<String, String> dateTime = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTime.put("data_hora", now.format(formatter));
        return dateTime;
    }
}
