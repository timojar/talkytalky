package com.timo.talkytalky;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	
    	http
        	.csrf().disable()
            .authorizeRequests()
            
            	.antMatchers("/","/talkytalky/**", "/user/register","/password/**","/user/resetpassword", "/css/**","../css/**", "/js/**", "/fonts/**").permitAll()
            	.antMatchers("/user/account").access("hasRole('ROLE_USER')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/account")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?succes");
    }

    @Autowired
    private DataSource dataSource;
    	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	
    	System.out.println("finding user");
        auth
        	.jdbcAuthentication()
        		.dataSource(dataSource)
        		.passwordEncoder(passwordEncoder())
        		.usersByUsernameQuery("SELECT email, salasana, enabled FROM kayttaja WHERE email=? and enabled = 1")
        		.authoritiesByUsernameQuery("SELECT k.email, a.rooli FROM kayttaja k JOIN kayttajaValtuus kv ON (k.Id = kv.kayttajaId) JOIN valtuus a ON (a.id = kv.valtuusId) WHERE k.email = ?");
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new StandardPasswordEncoder();
		return encoder;
	}
    
}