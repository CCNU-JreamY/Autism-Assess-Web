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

    PARAMCHECK_ERROR("mini-aaw01", "参数错误");


    /**
     * 对外错误码
     */
    private final String errorCode;
    /**
     * 对外错误描述
     */
    private final String errorDesc;
}
