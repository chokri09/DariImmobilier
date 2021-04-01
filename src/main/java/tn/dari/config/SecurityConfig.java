package tn.dari.config;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.dari.services.CustomLoginFailureHandler;
import tn.dari.services.CustomLoginSuccessHandler;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService ;
	@Autowired
    private CustomLoginFailureHandler loginFailureHandler;
    @Autowired
    private CustomLoginSuccessHandler successHandler;
	
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(encodePwd());		
	}
	
	//vulnérabilité de sécurité Web qui permet à un attaquant d’inciter les utilisateurs à effectuer des actions qu’ils n’ont pas l’intention d’effectuer
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
        .antMatchers("/rest/**").authenticated()
        .anyRequest().permitAll()
        .and()
        .formLogin().permitAll()
        .failureHandler(loginFailureHandler)
        .successHandler(successHandler)
        .and()
        .logout().permitAll();
		//http.csrf().disable();
		//http.authorizeRequests()
		//.antMatchers("/rest/**")
		//.authenticated()
		//.anyRequest()
		//.permitAll()
		//.and()
		//.formLogin()
		//.failureHandler(loginFailureHandler)
		//.successHandler(successHandler)
	
		//.usernameParameter("email")
		//.and()
		//.rememberMe()
		
		//.and()
		//.logout().permitAll();
		
	}
	@Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(encodePwd());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }
	 
	
	@Bean
	public BCryptPasswordEncoder encodePwd(){
		
		return new  BCryptPasswordEncoder();
	}
	
	
	
}
