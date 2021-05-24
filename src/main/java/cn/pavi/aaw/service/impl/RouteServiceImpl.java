package cn.pavi.aaw.service.impl;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;
import cn.pavi.aaw.enums.Error;
import cn.pavi.aaw.enums.PrivDesc;
import cn.pavi.aaw.service.IBusinessService;
import cn.pavi.aaw.service.IRouteService;
import cn.pavi.aaw.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:
 * @Author: JreamY
 * @Date: 2021/5/24
 **/
@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    private Map<String, IBusinessService> businessServiceMap;

    @Override
    public Response routeService(Request request) {

        IBusinessService businessService = businessServiceMap.get(request.getServiceId());
        if (businessService == null) {
            LogUtils.info("businessService is null: {}", request.getServiceId());
            return Response.newFailure(Error.PARAMCHECK_ERROR, PrivDesc.ROUTE_SERVICEID_ERROR);
        }

        Response response = Response.newSuccess();
        businessService.validate(request, response);
        if (!response.isSuccess()) {
            LogUtils.info("businessService validate fail");
            return response;
        }

        businessService.doBusiness(request, response);
        if (!response.isSuccess()) {
            LogUtils.info("businessService doBusiness fail");
            return response;
        }

        businessService.postBusiness(response);
        return response;
    }

}
