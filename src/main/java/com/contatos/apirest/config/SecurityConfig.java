package com.contatos.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {	
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
        .withUser("diogo")
        .password(passwordEncoder().encode("2020"))               
                .roles("USER");     
        } 
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeRequests()            
            .anyRequest()
                
                .authenticated()
                .antMatchers("/api/curso**/**")
                    .hasAnyRole("USER")
            .and()
            //.formLogin().permitAll()                      
            //.and()             
        .httpBasic();
        
    }

}