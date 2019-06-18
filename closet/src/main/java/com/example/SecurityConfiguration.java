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
	public void configure(WebSecurity web) throws Exception {
		//静的リソースへのアクセスに対するセキュリティ設定を無視
		web.ignoring().antMatchers("/webjars/**", "/css/**");
		}

	@Override
	//認可、ログイン・ログアウトに関する設定
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()	//認可に関する設定
		.antMatchers("/").permitAll();
		}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();	//パスワードのハッシュ化
}
}