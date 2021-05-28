package cn.pavi.aaw.constant;

/**
 * 变量存放
 */
public interface Constant {

    /**
     * /common/request_route.json 请求参数
     */
    interface Request {
        String SERVICE_ID = "serviceId";
        String PARAM = "param";
    }

    /**
     * /common/request_route.json param 业务请求参数
     */
    interface Param {

    }

    /**
     * Logback MDC ： LRU
     */
    interface MDC {
        String TRANSACTION_ID = "transactionId";
    }
}
