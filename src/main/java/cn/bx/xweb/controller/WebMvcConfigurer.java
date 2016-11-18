package cn.bx.xweb.controller;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		System.out.println("===============加载cors");
		registry.addMapping("").allowedHeaders("","");
		registry.addMapping("/*").allowedOrigins("http://localhost");
	}
	
}
