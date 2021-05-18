package cn.pavi.aaw.controller;

import cn.pavi.aaw.config.SwitchConfig;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SwitchConfig switchConfig;

    @GetMapping("/get.json")
    public String healthCheckGet() {

        System.out.println(switchConfig.getRedisOpen());
        System.out.println(switchConfig.getSingleServer());
        return "healthy get";
    }

    @PostMapping("/post.json")
    public String healthCheckPost() {
        return "healthy post";
    }
}
