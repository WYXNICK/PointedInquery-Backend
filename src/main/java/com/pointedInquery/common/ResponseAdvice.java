package com.pointedInquery.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@ControllerAdvice(annotations = {RestController.class}) // 通过注解进行过滤，拦截指定请求响应，避免错误拦截
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
	@Autowired
	private ObjectMapper objectMapper;
	private static final String Server = "ServerResponse";
	/**
	 * 是否支持advice功能
	 * 可以选择让哪些方法或者类进入beforeBodyWrite方法
     * returnType，获取类名和方法名
     * 通过returnType.getMethod().getDeclaringClass.getName获取类名
     * converterType 表示当前请求使用的一个数据转换器
	 */
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		// 不拦截已生成的ServerResponse
		String string=returnType.getMethod().getGenericReturnType().getTypeName();
        return !string.contains(Server);
	}

	// 对返回的数据进行处理
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		System.out.println("-----自动统一返回格式-----");
		if(body instanceof Boolean) {
			if(body.equals(true))
				return ServerResponse.success(null);
			else {
				return ServerResponse.failure(ReturnCode.RC999);
			}
		}
		if (body instanceof String) {
			try {
				return objectMapper.writeValueAsString(ServerResponse.success(body));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
	    }
		return ServerResponse.success(body);
	}

}
