package com.hand.consumer.service;

import com.hand.consumer.service.impl.ConsumerFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-producer",fallback = ConsumerFallbackImpl.class)
public interface ConsumerService {
    @GetMapping("/producer/hello")
    String feign();
}
