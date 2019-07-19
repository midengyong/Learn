package com.lrfc.shiro.common.response;

/**
 * Created on 2019/4/30<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class ResponseData<T> {

    /**
     * 具体的返回信息, 主要是查询结果
     */
    public T data;

    /**
     * http 响应状态及信息
     */
    public int code;

    /**
     * 业务响应的提示信息
     */
    public String msg;

    public static ResponseData findSuccess(Object o) {
        ResponseData responseData = new ResponseData();
        responseData.code = BusinessStatusCode.FIND_SUCCESS.getCode();
        responseData.msg =BusinessStatusCode.FIND_SUCCESS.getMessage();
        responseData.data = o;
        return responseData;
    }

    public static ResponseData findFailed() {
        ResponseData responseData = new ResponseData<>();
        responseData.code = BusinessStatusCode.FIND_FAILED.getCode();
        responseData.msg = BusinessStatusCode.FIND_FAILED.getMessage();
        return responseData;
    }
    public static ResponseData findParamError() {
        ResponseData responseData = new ResponseData<>();
        responseData.code = BusinessStatusCode.FIND_BAD_PARAM.getCode();
        responseData.msg = BusinessStatusCode.FIND_BAD_PARAM.getMessage();
        return responseData;
    }
    public static ResponseData findNoData() {
        ResponseData responseData = new ResponseData<>();
        responseData.code = BusinessStatusCode.FIND_NO_DATA.getCode();
        responseData.msg = BusinessStatusCode.FIND_NO_DATA.getMessage();
        return responseData;
    }
    public static ResponseData OperationSuccess() {
        ResponseData responseData = new ResponseData<>();
        responseData.code = BusinessStatusCode.OPERATION_SUCCESS.getCode();
        responseData.msg = BusinessStatusCode.OPERATION_SUCCESS.getMessage();
        return responseData;
    }
    public static ResponseData<String> OperationFailed() {
        ResponseData<String> responseData = new ResponseData<>();
        responseData.code = BusinessStatusCode.OPERATION_FAILED.getCode();
        responseData.msg = BusinessStatusCode.OPERATION_FAILED.getMessage();
        return responseData;
    }

    public static ResponseData<String> CustomeExceptionFallBack(int code,String message) {
        ResponseData<String> responseData = new ResponseData<>();
        responseData.code = code;
        responseData.msg = message;
        return responseData;
    }
	public static ResponseData<String> CustomeExceptionFallBack(BusinessStatusCode businessStatusCode) {
		return CustomeExceptionFallBack(businessStatusCode.getCode(),businessStatusCode.getMessage());
	}
}
