package ca.skip.api.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ca.skip.api.config.Constants;
import ca.skip.api.config.RestAuthorizationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = { RestAuthenticationEntryPoint.class })
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	public AppSecurityConfig() {
		super(true);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().and()//
				.anonymous().and()//
				.servletApi().and()//
				.headers().cacheControl().and()//
				.authorizeRequests()//
				.antMatchers(HttpMethod.OPTIONS, Constants.REST_BASE_PATH.concat("/**")).permitAll() // allow CORS
																										// option calls
				.antMatchers(HttpMethod.OPTIONS, "/auth/**").permitAll() // allow CORS option calls
				.antMatchers(HttpMethod.OPTIONS, "/logout").permitAll() // allow CORS option calls
				.antMatchers(HttpMethod.GET, "/config/**").permitAll()//
				.antMatchers(Constants.REST_BASE_PATH.concat("/public/**")).permitAll()//
				.antMatchers("/favicon.ico").permitAll()//
				.antMatchers("/login").permitAll()//
				.antMatchers("/auth").permitAll()//
				.antMatchers("/sso/**").permitAll()//
				.antMatchers("/portal/**").permitAll()//
				.antMatchers("/check/**").permitAll()//
				.antMatchers("/").permitAll()//
				.anyRequest().authenticated().and()//
				.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()//
				.addFilterBefore(new RestAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Autowired
	public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
		this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
	}

}
