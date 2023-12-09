package com.pointedInquery.common;

public enum ReturnCode {
	/**操作成功**/
    RC100(100,"操作成功"),
    /**操作失败，主要是数据库的操作**/
    RC999(999,"操作失败"),
 
    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"没有权限访问该资源"),
    INFO_EMPTY(1000,"必填信息不得为空"),
    INFO_REPEAT(1001,"信息不得重复上传"),
    USERID_OR_PASSWORD_ERROR(1002,"用户账号或密码错误"),
    USEID_NOT_EXISTS(1003, "用户账号不存在"),
	USERID_USED(1004,"手机号已经被注册"),
	PHOTO_UPLOAD_FAILED(1005,"图片上传失败");
 
    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;
 
    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }
 
    public int getCode() {
        return code;
    }
 
    public String getMessage() {
        return message;
    }
    
    public static String getMessageByCode(int code) {
    	for(ReturnCode tmp:ReturnCode.values()) {
    		if(tmp.getCode()==code) {
    			return tmp.getMessage();
    		}
    	}
    	// 填写的状态码没有被定义过
    	return null;
    }
}
