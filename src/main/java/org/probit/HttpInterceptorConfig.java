package org.probit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
  * HttpInterceptorConfig
  *
  * @author sunghyun
  * @since 2016. 12. 05.
  */
@Configuration
public class HttpInterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/loginPage")
				.excludePathPatterns("/login")
				.excludePathPatterns("/lib/**");
	}
}
