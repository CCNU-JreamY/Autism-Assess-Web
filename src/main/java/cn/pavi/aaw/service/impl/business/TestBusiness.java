package cn.pavi.aaw.service.impl.business;

import cn.pavi.aaw.service.IBusinessService;
import cn.pavi.aaw.util.LogUtils;
import org.springframework.stereotype.Service;

/**
 * @Description: 通用接口处理服务类
 * @Author: JreamY
 * @Date: 2021/5/24
 **/
@Service("testBusiness")
public class TestBusiness<Request, Response> implements IBusinessService<Request, Response> {


    @Override
    public void validate(Request request, Response response) {

        LogUtils.info("testBusiness validate");
    }

    @Override
    public void doBusiness(Request request, Response response) {
        LogUtils.info("testBusiness doBusiness");
    }

    @Override
    public void postBusiness(Response response) {
        LogUtils.info("testBusiness postBusiness");
    }
}
