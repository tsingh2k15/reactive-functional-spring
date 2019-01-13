package com.example.functionalspring.reactive.websocket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;

@Configuration
public class WebSocketConfig {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketConfig.class);

    @Bean
    WebSocketHandlerAdapter webSocketHandlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

    @Bean
    WebSocketHandler webSocketHandler() {
        return session -> {
            Flux<WebSocketMessage> messageFlux =
                    Flux.<String>generate(sink -> sink.next("Ping @" + Instant.now().toString()))
                    .map(session::textMessage)
                    .delayElements(Duration.ofSeconds(1))
                    .doFinally(signalType -> LOG.info("Good Bye"));

            return session.send(messageFlux);
        };
    }

    @Bean
    HandlerMapping handlerMapping() {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setUrlMap(Collections.singletonMap("/ws/ping", webSocketHandler()));
        return simpleUrlHandlerMapping;
    }
}
