package com.test.config;

import com.test.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;


@Configuration
public class LoginWebConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 创建List 添加需要拦截的路径
		ArrayList<String> interceptPath = new ArrayList<>();
		interceptPath.add("/order/**");
		interceptPath.add("/customer/**");

		// 创建List 添加需要放行的路径
		ArrayList<String> clearancePaths = new ArrayList<>();
		clearancePaths.add("/customer/login");
		clearancePaths.add("/customer/regist");
		clearancePaths.add("/customer/china");


		// 添加一个拦截器
		registry.addInterceptor(new LoginInterceptor())
				// 添加拦截路径
				.addPathPatterns(interceptPath)
				// 指定放行的路径
				.excludePathPatterns(clearancePaths);
	}
}
