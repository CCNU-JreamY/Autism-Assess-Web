package cn.pavi.aaw.service.impl;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.DataResponse;
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
 * @Description: 业务处理转发服务类
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
            LogUtils.info(this.getClass(), "businessService is null: {}", request.getServiceId());
            return Response.newFailure(Error.PARAMCHECK_ERROR, PrivDesc.ROUTE_SERVICEID_ERROR);
        }

        boolean needData = businessService.dataResponse();
        Response response = needData ? DataResponse.newSuccess() : Response.newSuccess();
        businessService.validate(request, needData ? (DataResponse) response : response);
        if (!response.statusOk()) {
            LogUtils.info(this.getClass(), "businessService validate fail");
            return needData ? (DataResponse) response : response;
        }

        businessService.doBusiness(request, needData ? (DataResponse) response : response);
        if (!response.statusOk()) {
            LogUtils.info(this.getClass(), "businessService doBusiness fail");
            return needData ? (DataResponse) response : response;
        }

        businessService.postBusiness(needData ? (DataResponse) response : response);
        return needData ? (DataResponse) response : response;
    }

}
