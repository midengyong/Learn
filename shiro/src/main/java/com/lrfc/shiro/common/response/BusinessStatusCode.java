package com.lrfc.shiro.common.response;

public enum BusinessStatusCode {
    FIND_SUCCESS(200, "查询成功"),
    FIND_FAILED(1000, "查询失败"),
    FIND_BAD_PARAM(1001, "查询参数错误"),
    FIND_NO_DATA(1002, "当前没有数据"),
    OPERATION_SUCCESS(200,"当前操作成功"),
    OPERATION_FAILED(1003,"当前操作失败"),
    CHANGE_PASSWORD_FAILED(1004,"旧密码错误"),
    PARAM_ERROR(1005,"请求参数错误");
    /**
     * code  状态码
     */
    private int code;

    /**
     * message  状态信息
     */
    private String message;

    /**
     * Description:  构造方法
     *
     * @param code  状态值
     * @param message  状态信息
     */
    private BusinessStatusCode(int code, String message) {
        this.code    = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
