package com.hand.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @ClassName ClientController
 * @Description TODO
 * @Author lee
 * @Date 2019/12/6 16:19
 * @Version 1.0
 */
@RefreshScope
@RestController
public class ClientController {
    @Value("${info.profile:error}")
    private String profile;

    @GetMapping("/info")
    public Mono<String> clientInfo() {
        return Mono.justOrEmpty(profile);
    }
}
