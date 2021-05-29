package cn.pavi.aaw.mapper;

import cn.pavi.aaw.bean.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int addUser( UserEntity user);



}
