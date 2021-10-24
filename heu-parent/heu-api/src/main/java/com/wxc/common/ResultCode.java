package com.wxc.common;

import lombok.Data;

public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(200, "操作成功！"),

    /* 错误状态码 */
    FAIL(-1, "操作失败！"),

    /* 参数错误：10001-19999 */
    OPENID_ERROR(10001, "OPENID解析错误"),

    TOKEN_ERROR(10002, "token超时"),

    UPDATE_FAIL(10003, "更新失败"),

    SYSTEM_ERROR(10004, "系统错误");

    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}