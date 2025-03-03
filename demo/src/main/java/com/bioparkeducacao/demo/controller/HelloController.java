package com.bioparkeducacao.demo.controller;

import com.bioparkeducacao.demo.service.BioparkService;
import com.bioparkeducacao.demo.service.GeoLocationService;
import com.bioparkeducacao.demo.service.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private BioparkService bioparkService;

    @Autowired
    private GeoLocationService geoLocationService;

    @Autowired
    private DateTimeService dateTimeService;

    // Endpoint para renderizar a página Thymeleaf com dados dinâmicos
    @GetMapping("/")
    public String hello(Model model) {
        // Passa dados dinâmicos para o template Thymeleaf
        model.addAttribute("dataHora", dateTimeService.getDateTime().get("data_hora"));
        model.addAttribute("cidade", geoLocationService.getLocation().get("cidade"));
        model.addAttribute("estado", geoLocationService.getLocation().get("estado"));
        model.addAttribute("pais", geoLocationService.getLocation().get("pais"));
        model.addAttribute("latitude", geoLocationService.getLocation().get("latitude"));
        model.addAttribute("longitude", geoLocationService.getLocation().get("longitude"));
        model.addAttribute("dadosBiopark", bioparkService.buscarDados());

        return "hello";  // Renderiza o template hello.html
    }

    // Endpoint para retornar os dados do site Biopark
    @GetMapping("/biopark")
    public String getBioparkData() {
        return bioparkService.buscarDados();  // Retorna os dados do Biopark diretamente
    }

    // Endpoint para retornar a localização do servidor
    @GetMapping("/localizacao")
    public String getLocation() {
        return geoLocationService.getLocation().toString();  // Retorna a localização do servidor
    }

    // Endpoint para retornar a data e hora do servidor
    @GetMapping("/datetime")
    public String getDateTime() {
        return dateTimeService.getDateTime().toString();  // Retorna a data e hora
    }
}
