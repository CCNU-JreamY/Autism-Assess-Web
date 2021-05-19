package cn.pavi.aaw.controller;

import cn.pavi.aaw.annotation.PostValidator;
import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
@RestController
@RequestMapping("/health_check")
public class HealthCheckController {

    @Autowired
    private NacosConfig nacosConfig;

    @GetMapping("/get.json")
    public String healthCheckGet() {

        System.out.println(nacosConfig.getAge());
        System.out.println(nacosConfig.getName());
        System.out.println(nacosConfig.getGender());
        return nacosConfig.getName() + nacosConfig.getAge() + nacosConfig.getGender();
//        return "healthy get";
    }

    @PostMapping("/post.json")
    @PostValidator(params = {"key1", "key2"})
    public String healthCheckPost(@RequestBody Request request) {
        return "healthy post";
    }
}
