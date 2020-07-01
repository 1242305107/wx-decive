package com.tckj.wx.application.common.constants;

/**
 * @author WCH
 * @date 2020/6/28 14:40
 */
public enum CodeEnum {
    SUCCESS("10000","操作成功"),
    ERROR("20000","操作失败");

    private String resp_code;

    private String resp_msg;
    CodeEnum(String resp_code, String resp_msg){
        this.resp_code = resp_code;
        this.resp_msg=resp_msg;
    }

    public String getCode() {
        return resp_code;
    }
    public String getMsg() {
        return resp_msg;
    }
}
