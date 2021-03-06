package cn.pavi.aaw.service;

public interface IBusinessService<Q, P> {

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
