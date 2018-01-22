package com.fendo.shiro.common.utils;

 /**
  * 返回码
  * @author sunfa
  *
  */
public enum SimpleCode {
    SUCCESS("000", "成功"),
    ERROR("001", "失败"),
	BPSUCCESS("success", "true"),
	BPMESSAGE("message", "上传成功"),
	BPERROR("success", "true"),
	BPERRORMESSAGE("message", "上传成功");
    private String  code;
    private String message;

    SimpleCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
