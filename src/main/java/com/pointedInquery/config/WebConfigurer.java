package com.pointedInquery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	@Bean
	 public LoginInterceptor SetInterceptor() {
	    return new LoginInterceptor();
	 }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(SetInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/swagger-ui.html")
				.excludePathPatterns("/v2/api-docs")
				.excludePathPatterns("/swagger-resources/**")
				.excludePathPatterns("/webjars/**");
	}
}
