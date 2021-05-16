package sg.com.studymama.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import sg.com.studymama.component.CustomJwtAuthenticationFilter;
import sg.com.studymama.component.JwtAuthenticationEntryPoint;
import sg.com.studymama.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService userDetailsService;

	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/swagger-ui/**", "/v3/api-docs/**");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/helloadmin").hasRole("ADMIN")
				.antMatchers("/hellouser", "/updateProfile", "/getProfile", "/categoryList", "/profilePicture")
				.hasAnyRole("ADMIN", "USER")
				.antMatchers("/authenticate", "/register", "/search", "/postDelete", "/post", "/post/*", "/postData",
						"/postFormSubmit", "/fakecategorysearch", "/commentSubmit", "/commentDelete/*", "/rateSubmit",
						"/Recommendation", "/greeting", "/demo", "/initPostData/*", "/postService/*",
						"/actuator/health", "/v2/api-docs", // for swagger stuff
						"/configuration/ui", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html",
						"/swagger-ui/*", "/swagger-ui/index.html", "/v3/api-docs/", "/webjars/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().httpBasic()
				.authenticationEntryPoint(unauthorizedHandler).and().
				// make sure we use stateless session; session won't be used to
				// store user's state.

				sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
