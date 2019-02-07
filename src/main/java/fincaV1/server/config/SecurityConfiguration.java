package fincaV1.server.config;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fincaV1.server.entity.VecinoBean;

 

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	@Autowired
	HttpServletRequest session;
	
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	VecinoBean vecinoSesion = new VecinoBean();
//    	vecinoSesion = (VecinoBean) session.getSession().getAttribute("vecino");
//    	if(vecinoSesion != null) {
//    		if(vecinoSesion.getId_tipovecino().getId() == 1) {
//    			auth.inMemoryAuthentication().withUser(vecinoSesion.getLogin()).password(vecinoSesion.getPass()).roles("ADMIN");    		
//    		}else {
//    			auth.inMemoryAuthentication().withUser(vecinoSesion.getLogin()).password(vecinoSesion.getPass()).roles("USER");
//    		}    		
//    	}
//    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/login")
        .permitAll()
    .antMatchers("/vecinos")
        .hasAnyRole("USER");
//    .and()		
//        .antMatchers("/vecinos").hasAnyRole("ADMIN")
//        .and()
//        .antMatchers("/login").permitAll();
//        .antMatchers("/login")
//            .permitAll()
    }

}
