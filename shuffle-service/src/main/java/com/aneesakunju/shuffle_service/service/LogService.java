package com.aneesakunju.shuffle_service.service;

import com.aneesakunju.shuffle_service.model.CreateShuffleRequest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Service
@EnableAsync
public class LogService {
    private final RestClient restClient;
    private final DiscoveryClient discoveryClient;

    public LogService(DiscoveryClient discoveryClient, RestClient.Builder restClientBuilder) {
        this.discoveryClient = discoveryClient;
         this.restClient = restClientBuilder.build();
    }

    @Async
    public void logRequest(CreateShuffleRequest request) {
        ServiceInstance serviceInstance = discoveryClient.getInstances("LOG-SERVICE").get(0);
        restClient.post()
                .uri(serviceInstance.getUri()+"/log")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}
