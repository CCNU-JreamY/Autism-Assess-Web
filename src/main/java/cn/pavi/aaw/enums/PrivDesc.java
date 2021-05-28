package cn.pavi.aaw.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: 对内错误码和错误描述：aaw-privXX形式
 * @Author: JreamY
 * @Date: 2021/5/25
 */
@AllArgsConstructor
@Getter
public enum PrivDesc {

    ROUTE_SERVICEID_ERROR("aaw-priv01", "serviceId有误");

    private final String code;
    private final String desc;
}
