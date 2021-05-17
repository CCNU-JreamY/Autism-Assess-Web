package cn.pavi.aaw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
@RestController
@RequestMapping("/health_check")
public class HealthCheckController {

    @GetMapping("/get.json")
    public String healthCheckGet() {
        return "healthy get";
    }

    @PostMapping("/post.json")
    public String healthCheckPost() {
        return "healthy post";
    }
}
