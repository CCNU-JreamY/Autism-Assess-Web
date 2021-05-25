package cn.pavi.aaw.service;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;

public interface IRouteService {

    /**
     * 业务处理转发
     *
     * @param request
     * @return
     */
    default Response routeService(Request request) {
        return Response.newFailure();
    }
}
