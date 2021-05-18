package cn.pavi.aaw.bean.exception;

import lombok.Getter;

/**
 * @Description: 自定义系统异常类
 * @Author: JreamY
 * @Date: 2021/5/18
 **/
@Getter
public class SystemException extends RuntimeException {

    /**
     * 对外异常描述
     */
    private String pubDesc;
    /**
     * 对内异常描述
     */
    private String privDesc;

    public SystemException(String pubDesc, String privDesc) {
        this.pubDesc = pubDesc;
        this.privDesc = privDesc;
    }
}
