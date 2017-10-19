package org.pitechplus.camprom.config;

import org.pitechplus.camprom.interceptor.RequestCounterInterceptor;
import org.pitechplus.camprom.interceptor.RequestTimingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author atincu
 */
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    RequestCounterInterceptor getRequestCounterInterceptor() {
        return new RequestCounterInterceptor();
    }

    @Bean
    RequestTimingInterceptor getRequestTimingInterceptor() {
        return new RequestTimingInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(getRequestCounterInterceptor());
        interceptorRegistry.addInterceptor(getRequestTimingInterceptor());
    }

}
