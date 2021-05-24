package cn.pavi.aaw.service;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;

public interface IRouteService {

    default Response routeService(Request request) {
        return Response.newFailure();
    }
}
