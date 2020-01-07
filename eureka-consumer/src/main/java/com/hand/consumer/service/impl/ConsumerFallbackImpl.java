package com.hand.consumer.service.impl;

import com.hand.consumer.service.ConsumerService;
import org.springframework.stereotype.Component;

/**
 * @ClassName ConsumerFallbackImpl
 * @Description TODO
 * @Author lee
 * @Date 2019/12/6 9:16
 * @Version 1.0
 */
@Component
public class ConsumerFallbackImpl implements ConsumerService {
    @Override
    public String feign() {
        return "没想到吧出错了";
    }
}
