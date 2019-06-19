package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();	//パスワードのハッシュ化
		}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//静的リソースへのアクセスに対するセキュリティ設定を無視
		web.ignoring().antMatchers("/webjars/**", "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
		}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	//認可、ログイン・ログアウトに関する設定
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()	//認可に関する設定
			.antMatchers("/").permitAll();
			/*.antMatchers("/login").permitAll()
			.antMatchers("/users/createacc").permitAll()
			.anyRequest().authenticated();*/
		http.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/login")
			.failureUrl("/login?error")
			.successForwardUrl("/users/profile")
			.usernameParameter("user_id")
			.passwordParameter("password");
		http.logout()
			.logoutUrl("/logout**")
			.logoutSuccessUrl("/login");
		}
}