package cn.pavi.aaw.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PrivDesc {

    TEMPLATE("aaw-priv01", "内部错误记录模板");

    private final String code;
    private final String desc;
}
