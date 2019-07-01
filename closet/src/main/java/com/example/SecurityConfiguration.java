package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {//特定のリクエストだけセキュリティ設定を無視する条件をかける
		web.ignoring().antMatchers("/webjars/**", "/css/**","/js/**", "/images/**");//webjarsやcssへのアクセスに対して、上記の機能が働く
	}

	@Override
	//認可、ログイン・ログアウトに関する設定
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/coordinate/add").permitAll()
				.antMatchers("/css/**","/js/**","/images/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginProcessingUrl("/login")
				.loginPage("/login")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/top", true)
				.usernameParameter("userId").passwordParameter("password")
				.and()
				.logout()
				.logoutSuccessUrl("/login");
		}

	@Bean
	PasswordEncoder passwordEncoder() {	//パスワードのハッシュ化
		return new Pbkdf2PasswordEncoder();
	}
}