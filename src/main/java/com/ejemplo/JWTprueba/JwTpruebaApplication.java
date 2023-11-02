package com.ejemplo.JWTprueba;

import com.ejemplo.JWTprueba.filter.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwTpruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwTpruebaApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<SimpleFilter> simpleFilter(){
		FilterRegistrationBean<SimpleFilter> registrationBean= new FilterRegistrationBean<>();
		registrationBean.setFilter(new SimpleFilter());
		registrationBean.addUrlPatterns("/restringido");
		return registrationBean;
	}
}
