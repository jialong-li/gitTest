package com.hand.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients
@SpringCloudApplication
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    // LoadBalancerClient 负载均衡客户端
   /* @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

   // Ribbon 基于HTTP和TCP的负载均衡客户端
   @Bean
   @LoadBalanced
   public RestTemplate restTemplate() {
        return new RestTemplate();
   }
}
