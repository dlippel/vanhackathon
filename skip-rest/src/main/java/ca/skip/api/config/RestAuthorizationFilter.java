package ca.skip.api.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;

import ca.skip.api.config.security.TokenAPI;
import ca.skip.api.config.security.User;
import ca.skip.api.config.security.UserAuthentication;
import io.jsonwebtoken.JwtException;

public class RestAuthorizationFilter implements Filter {

	public RestAuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		//
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;

		SecurityContextHolder.clearContext();

		if (UserAuthentication.AUTHENTICATE) {
			try {
				final User user = TokenAPI.getUserFromRequest(httpRequest);
				if (user != null) {
					auth(user);
				}
			} catch (JwtException e) {
				// responde um JSON com uma "lista" de erros
				httpResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
				httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				httpResponse.getOutputStream().println("[\"" + e.getMessage() + "\" ]");
			}
		}

		filterChain.doFilter(request, response);

	}

	private void auth(User user) throws ServletException {
		SecurityContextHolder.getContext().setAuthentication(new UserAuthentication(user));
	}

	@Override
	public void destroy() {
		//
	}
}