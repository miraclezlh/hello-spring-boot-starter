package com.zlh.hello_spring_boot_starter.controller;

import com.zlh.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 70635
 */
@RequestMapping("/hello")
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;


    @GetMapping("/demo")
    public void  home() {
        helloService.send("starter come in!");
    }
}
