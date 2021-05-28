package cn.pavi.aaw.bean.response;

import cn.pavi.aaw.enums.Error;
import cn.pavi.aaw.enums.PrivDesc;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: 通用返回体类
 * @Author: JreamY
 * @Date: 2021/5/17
 **/
@Getter
@Setter
@ToString
public class Response implements Serializable {

    protected final static Integer SUCCESS = 0;
    protected final static Integer FAILURE = 1;

    /**
     * 0成功，1失败
     */
    private Integer resultCode;
    /**
     * 对外错误码
     */
    private String errorCode;
    /**
     * 对内错误码
     */
    private String privCode;
    /**
     * 错误描述
     */
    private String errorDesc;

    public static Response newSuccess() {
        Response response = new Response();
        return response.setSuccess();
    }

    public static Response newFailure() {
        Response response = new Response();
        return response.setFailure();
    }

    public static Response newFailure(Error error) {
        return newFailure().setError(error);
    }

    public static Response newFailure(Error error, PrivDesc privDesc) {
        return newFailure(error, privDesc, false);
    }

    public static Response newFailure(Error error, PrivDesc privDesc, boolean changeDesc) {
        Response response = newFailure(error);
        response.setPrivCode(privDesc.getCode());
        if (changeDesc) {
            response.setErrorDesc(privDesc.getDesc());
        }
        return response;
    }

    public Response setSuccess() {
        this.resultCode = SUCCESS;
        return this;
    }

    public Response setFailure() {
        this.resultCode = FAILURE;
        return this;
    }

    public Response setError(Error error) {
        this.errorCode = error.getErrorCode();
        this.errorDesc = error.getErrorDesc();
        return this;
    }

    public boolean statusOk() {
        return SUCCESS.equals(this.resultCode);
    }
}
