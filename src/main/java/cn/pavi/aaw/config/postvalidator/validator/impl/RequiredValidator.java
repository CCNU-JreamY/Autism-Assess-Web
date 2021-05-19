package cn.pavi.aaw.config.postvalidator.validator.impl;

import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;
import cn.pavi.aaw.config.postvalidator.validator.IValidator;
import cn.pavi.aaw.enums.Error;
import cn.pavi.aaw.util.LogUtils;
import cn.pavi.aaw.util.ParamUtils;

/**
 * @Description: 参数非空校验器类
 * @Author: JreamY
 * @Date: 2021/5/19
 **/
public class RequiredValidator implements IValidator {

    @Override
    public Response validate(Request request, String... variates) {

        for (String variate : variates) {
            if (ParamUtils.paramCheckNull(request.get(variate))) {
                LogUtils.info("param -> {} is null", variates);
                return Response.newFailure(Error.PARAMCHECK_ERROR);
            }
        }
        return Response.newSuccess();
    }
}
