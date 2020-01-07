package com.hand.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProducerController
 * @Description TODO
 * @Author lee
 * @Date 2019/12/5 16:16
 * @Version 1.0
 */
@RequestMapping("/producer")
@RestController
public class ProducerController {

    @GetMapping("/hello")
    public String hello() {
        return "123";
    }
}
