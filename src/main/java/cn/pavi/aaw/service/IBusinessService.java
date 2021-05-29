package cn.pavi.aaw.service;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;

public interface IBusinessService<Q extends Request, P extends Response> {

    /**
     * 是否要返回data数据
     *
     * @return
     */
    default boolean dataResponse() {
        return false;
    }

    /**
     * 业务前置参数校验
     *
     * @param request
     * @param response
     * @return
     */
    default void validate(Q request, P response) {
    }

    /**
     * 业务处理
     *
     * @param request
     * @param response
     */
    default void doBusiness(Q request, P response) {
    }

    /**
     * 业务后置返回数据处理
     *
     * @param response
     */
    default void postBusiness(P response) {

    }
}
