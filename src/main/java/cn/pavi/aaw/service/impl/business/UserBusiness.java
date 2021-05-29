package cn.pavi.aaw.service.impl.business;

import cn.pavi.aaw.bean.entity.UserEntity;
import cn.pavi.aaw.bean.request.Request;
import cn.pavi.aaw.bean.response.Response;
import cn.pavi.aaw.mapper.UserMapper;
import cn.pavi.aaw.service.IBusinessService;
import cn.pavi.aaw.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("UserBusiness")
public class UserBusiness implements IBusinessService<Request, Response> {

    @Autowired
    private UserMapper userMapper;

    private UserEntity user=new UserEntity();

    @Override
    public void validate(Request request, Response response) {


        LogUtils.info(this.getClass(), "UserBusiness validate");

    }

    @Override
    public void doBusiness(Request request, Response response) {

        user.setAddress((String)request.getParam().get("address"));
        user.setGender((String)request.getParam().get("gender"));
        user.setOpenId((String)request.getParam().get("openid"));

        LogUtils.info(this.getClass(), "UserBusiness doBusiness");
        userMapper.addUser(user);
    }

    @Override
    public void postBusiness(Response response) {
        LogUtils.info(this.getClass(), "UserBusiness postBusiness");
    }
}
