package com.pointedInquery.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
	//null的字段不参加序列化
	private int status; //接口状态
	private String msg; //提示信息
	private T data;
	
	
	public ServerResponse(){}
	
	public static <T> ServerResponse<T> success(T data) {
		ServerResponse<T> response=new ServerResponse<T>();
		response.setData(data);
		response.setMsg(ReturnCode.RC100.getMessage());
		response.setStatus(ReturnCode.RC100.getCode());
		return response;
	}
	
	public static <T> ServerResponse<T> failure(int code) {
		ServerResponse<T> response=new ServerResponse<T>();
		response.setMsg(ReturnCode.getMessageByCode(code));
		response.setStatus(code);
		return response;
	}
	
	public static <T> ServerResponse<T> failure(ReturnCode returnCode) {
		ServerResponse<T> response=new ServerResponse<T>();
		response.setMsg(returnCode.getMessage());
		response.setStatus(returnCode.getCode());
		return response;
	}
}
