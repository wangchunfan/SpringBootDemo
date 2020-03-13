package wang.chunfan.springbootdemo.aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.chunfan.springbootdemo.aop.anotation.LogJoinPoint;

@RestController
public class HelloController {

    @GetMapping("hello")
    @LogJoinPoint
    public String getHello() {
        System.out.println("hello word");
        return "hello word!";
    }

    @GetMapping
    public String get() {
        System.out.println("你好,欢迎使用 AOP");
        getHello();
        return "你好,欢迎使用 AOP";
    }
}
