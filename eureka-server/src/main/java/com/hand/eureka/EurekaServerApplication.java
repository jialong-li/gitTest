package com.hand.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**启动一个服务注册中心 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    /** 我做了一个 */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
