package com.hand.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**可省略@EnableEurekaClient*/
@SpringBootApplication
@RestController
public class EurekaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducerApplication.class, args);
    }

}
