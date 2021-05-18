package cn.pavi.aaw.config.postvalidator.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ValidatorEnum {

    REQUIRED("参数非空校验"),

    REGEX_NUMBER("纯数字校验"),

    REGEX_CUSTOM("自定义格式校验");

    private String desc;


}
