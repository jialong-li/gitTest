package com.hand.consumer.controller;

import com.hand.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author lee
 * @Date 2019/12/5 17:28
 * @Version 1.0
 */
@RequestMapping("/consumer")
@RestController
public class ConsumerController {
    private LoadBalancerClient client;
    private RestTemplate restTemplate;
    private ConsumerService consumerService;

    @Autowired
    public ConsumerController(RestTemplate restTemplate, LoadBalancerClient client,ConsumerService consumerService) {
        this.restTemplate = restTemplate;
        this.client = client;
        this.consumerService = consumerService;
    }

    @GetMapping("/load")
    public String load() {
        ServiceInstance instance = client.choose("eureka-producer");
            String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/producer/hello";
            return "load" + restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/ribbon")
    public String ribbon() {
        try {
            //使用服务名 eureka-producer 取代了之前的具体的 host:port
            String url = "http://eureka-producer/producer/hello";
            return "ribbon" + restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return "error";
        }
    }

    /** Feign实现负载均衡 */
    @GetMapping("/feign")
    public String feign() {
        return "feign" + consumerService.feign();
    }

}
