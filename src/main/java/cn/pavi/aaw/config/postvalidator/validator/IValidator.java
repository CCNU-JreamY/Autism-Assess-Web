package cn.pavi.aaw.config.postvalidator.validator;

import cn.pavi.aaw.bean.response.Response;

public interface IValidator {

    default Response validate(String... variates) {
        return Response.newFailure();
    }
}
