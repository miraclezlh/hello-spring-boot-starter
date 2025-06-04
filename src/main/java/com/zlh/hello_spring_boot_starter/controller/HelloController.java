package com.zlh.hello_spring_boot_starter.controller;

import com.zlh.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


/**
 * @author 70635
 */
@RequestMapping("/hello")
@RestController
public class HelloController {
    /**
     * 限流策略 ： 1秒钟2个请求
     */
    private final RateLimiter limiter = RateLimiter.create(2.0);

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private HelloService helloService;


    @GetMapping("/demo")
    public void  home() {
        helloService.send("starter come in!");

        //500毫秒内，没拿到令牌，就直接进入服务降级
        boolean tryAcquire = limiter.tryAcquire(500, TimeUnit.MILLISECONDS);
        if (!tryAcquire) {
            System.out.println("进入服务降级，时间{}"+LocalDateTime.now().format(dtf));
            System.out.println("当前排队人数较多，请稍后再试！");
            return;
        }

        System.out.println("获取令牌成功，时间{}"+LocalDateTime.now().format(dtf));
        System.out.println("请求成功");
    }
}
