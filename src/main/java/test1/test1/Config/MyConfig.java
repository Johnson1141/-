package test1.test1.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import test1.test1.component.LoginHandlerInterceptor;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        LoginHandlerInterceptor loginHandlerInterceptor = new LoginHandlerInterceptor();
//        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**","/home").excludePathPatterns(loginHandlerInterceptor.getUrl());
    }
}
