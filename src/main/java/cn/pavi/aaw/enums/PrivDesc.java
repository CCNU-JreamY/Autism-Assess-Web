package cn.pavi.aaw.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PrivDesc {

    ROUTE_SERVICEID_ERROR("aaw-priv01", "serviceId有误");

    private final String code;
    private final String desc;
}
