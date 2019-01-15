/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fincaV1.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author jesus
 * Copiado del ruso este: https://github.com/ru-rocker/spring-rest-demo-cors
 */
//@Configuration
//public class CorsConfig {
//    @Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/fincaV1.server/**")
//				        .allowedOrigins("http://localhost:4200");
//			}
//		};
//	}
//}
//public class CorsConfig implements Filter{
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//            throws IOException, ServletException
//    {
//        HttpServletResponse response = (HttpServletResponse) resp;
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
//        response.setHeader("Access-Control-Allow-Credentials", "false");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Allow-Headers",
//                "Origin, Content-Type, X-Requested-With, accept, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
//        response.setHeader("Access-Control-Expose-Headers",
//                "Origin, Access-Control-Request-Method, Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
//        response.setHeader("Access-Control-Max-Age", "4000");
//        chain.doFilter(req, resp);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException
//    {
//    }
//
//    @Override
//    public void destroy()
//    {
//    }
//}