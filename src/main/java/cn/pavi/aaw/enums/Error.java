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

    TEMPLATE("mini-err01", "对外错误描述模板");


    /**
     * 对外错误码
     */
    private final String errorCode;
    /**
     * 对外错误描述
     */
    private final String errorDesc;
}
