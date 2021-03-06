package cn.pavi.aaw.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 错误码枚举
 * @Author: JreamY
 * @Create: 2021/04/23
 */
@AllArgsConstructor
@Getter
public enum Error {

    CUSTOM_SYSTEM_ERROR("aaw-err01", "系统异常"),

    SYSTEM_ERROR("aaw-err02", "系统异常"),

    PARAMCHECK_ERROR("aaw-err03", "参数错误");


    /**
     * 对外错误码
     */
    private final String errorCode;
    /**
     * 对外错误描述
     */
    private final String errorDesc;
}
