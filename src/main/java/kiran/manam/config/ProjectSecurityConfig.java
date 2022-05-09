package kiran.manam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/myAccount").authenticated().antMatchers("/myBalance").authenticated()
				.antMatchers("/myLoans").authenticated().antMatchers("/myCards").authenticated().antMatchers("/notices")
				.permitAll().antMatchers("contact").permitAll();
		http.formLogin();
		http.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("admin").and().withUser("read")
				.password("read").authorities("read").and().passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

}
