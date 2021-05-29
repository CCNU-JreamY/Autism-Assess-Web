package cn.pavi.aaw.bean.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * @Description: 可返回Map数据返回体类
 * @Author: JreamY
 * @Date: 2021/5/27
 **/
@Setter
@Getter
@ToString
public class DataResponse extends Response {

    private Map<String, Object> data;

    public static DataResponse newSuccess() {
        DataResponse response = new DataResponse();
        return (DataResponse) response.setSuccess();
    }

    public static DataResponse newSuccess(Map<String, Object> data) {
        Response response = Response.newSuccess();
        ((DataResponse) response).setData(data);
        return (DataResponse) response;
    }

}
