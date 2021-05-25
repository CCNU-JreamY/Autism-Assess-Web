package cn.pavi.aaw.bean.exception;

import cn.pavi.aaw.enums.PrivDesc;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 自定义系统异常类
 * @Author: JreamY
 * @Date: 2021/5/18
 **/
@Getter
@AllArgsConstructor
public class SystemException extends RuntimeException {

    /**
     * 对外异常描述
     */
    private String pubDesc;
    /**
     * 对内异常描述
     */
    private PrivDesc privDesc;

    @Override
    public String toString() {
        return "{SystemException: pubDesc -> " + pubDesc + ", privCode -> " + privDesc.getCode() + ", privDesc -> " + privDesc.getDesc() + "}";
    }

}
