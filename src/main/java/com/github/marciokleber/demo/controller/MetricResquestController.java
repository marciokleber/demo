package com.github.marciokleber.demo.controller;

import com.github.marciokleber.demo.metrics.HttpVerb;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/metric-request")
@RequiredArgsConstructor
public class MetricResquestController {

    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> requestCountAccess(@RequestParam String path, @RequestParam String verb) {
        HttpVerb httpVerb = HttpVerb.valueOf(verb.toUpperCase());
        String uri = getUri(path, httpVerb);
        try {
            String response = restTemplate.getForObject(uri, String.class);
            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity
                    .ok("Ainda não há métricas para o endpoint '" + path + "' com verbo HTTP '" + verb.toUpperCase() + "'\n");
        }
    }

    private String getUri(String path, HttpVerb verb) {
        return UriComponentsBuilder
                .fromUriString("http://localhost:8080/demo/actuator/metrics/http.server.requests")
                .queryParam("tag", "uri:" + path)
                .queryParam("tag", "method:" + verb.name())
                .toUriString();
    }
}
