package icu.epq.minihr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EPQ
 * <p>
 * 用于测试Security配置是否成功
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2() {
        return "hello basic!";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3() {
        return "hello advanced!";
    }
}
