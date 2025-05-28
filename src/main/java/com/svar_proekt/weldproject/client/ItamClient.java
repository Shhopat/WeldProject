package com.svar_proekt.weldproject.client;

import com.svar_proekt.weldproject.dto.ItamDTO;
import com.svar_proekt.weldproject.dto.ProductionExceptionDTO;
import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.model.Itam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ItamClient {
    private static final Logger logger = LoggerFactory.getLogger(ItamClient.class);
    private final WebClient webClient;

    @Autowired
    public ItamClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void addItam(ItamDTO itamDTO) {
        webClient.post().uri("/itam/save")
                .bodyValue(itamDTO)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> response.bodyToMono(ProductionExceptionDTO.class)
                                .flatMap(error -> Mono.error(new RuntimeException("Ошибка клиента: " + error.getMs() + " " + error.getLocalTime()))))
                .onStatus(status -> status.is5xxServerError(),
                        response -> response.bodyToMono(String.class).flatMap(error -> Mono.error(new RuntimeException("Ошибка сервера:" + error))))
                .toBodilessEntity()
                .doOnSuccess(v -> System.out.println("itam is registered"))
                .block();

    }

    public List<ItamDTO> getAllItam(ProductionObjectDTO productionObjectDTO) {
       logger.info("перешел в метод getAllItam в WebClient ");

        return webClient.get().uri(url -> url.path("/itam/getAll")
                        .queryParam("objectId", productionObjectDTO.getId())
                        .build())
                .retrieve()
                .onStatus(status -> status.is4xxClientError(),
                        response -> response.bodyToMono(ProductionExceptionDTO.class)
                                .flatMap(error -> Mono.error(new RuntimeException("Ошибка клиента: " + error.getMs() + " " + error.getLocalTime()))))
                .onStatus(status -> status.is5xxServerError(), response -> response.bodyToMono(String.class)
                        .flatMap(error -> Mono.error(new RuntimeException("Ошибка сервера: " + error))))
                .bodyToFlux(ItamDTO.class)
                .collectList()
                .doOnSuccess(v -> System.out.println("all itam "  + productionObjectDTO.getName() + " got"))
                .block();

    }

}
