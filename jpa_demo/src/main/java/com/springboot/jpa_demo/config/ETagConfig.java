package com.springboot.jpa_demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
public class ETagConfig {
  @Bean
  public FilterRegistrationBean<ShallowEtagHeaderFilter> shallowEtagHeaderFilter() {
    FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean = new FilterRegistrationBean<>(
        new ShallowEtagHeaderFilter());
    filterRegistrationBean.addUrlPatterns("/gym/*");
    filterRegistrationBean.setName("etagFilter");
    return filterRegistrationBean;
  }
}