package cn.pavi.aaw.controller;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;
import cn.pavi.aaw.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 通用接口控制器类
 * @Author: JreamY
 * @Date: 2021/5/22
 **/
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private IRouteService routeService;

    /**
     * 通用处理接口
     *
     * @param request
     * @return
     */
    @PostMapping("/request_route.json")
    public Response requestRoute(@RequestBody Request request) {
        return routeService.routeService(request);
    }
}
