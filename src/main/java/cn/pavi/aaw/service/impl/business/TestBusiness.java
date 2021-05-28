package cn.pavi.aaw.service.impl.business;

import cn.pavi.aaw.bean.exception.SystemException;
import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;
import cn.pavi.aaw.enums.PrivDesc;
import cn.pavi.aaw.mapper.TestMapper;
import cn.pavi.aaw.service.IBusinessService;
import cn.pavi.aaw.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 通用接口处理服务类
 * @Author: JreamY
 * @Date: 2021/5/24
 **/
@Service("testBusiness")
public class TestBusiness implements IBusinessService<Request, Response> {

    @Autowired
    private TestMapper testMapper;

    @Override
    public void validate(Request request, Response response) {

        LogUtils.info(this.getClass(), "testBusiness validate");
    }

    @Override
    public void doBusiness(Request request, Response response) {
        LogUtils.info(this.getClass(), "testBusiness doBusiness");
        testMapper.insert();
    }

    @Override
    public void postBusiness(Response response) {
        LogUtils.info(this.getClass(), "testBusiness postBusiness");
    }
}
