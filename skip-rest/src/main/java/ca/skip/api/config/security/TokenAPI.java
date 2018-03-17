package ca.skip.api.config.security;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class TokenAPI {

	private static final String SECRET_KEY = "secret";
	private static final byte[] KEY_BYTES = Base64Utils.encode(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

	private static final String NAME = "nam";
	private static final String EMAIL = "eml";

	private static final String BEARER = "Bearer ";

	public static final String AUTHORIZATION = "Authorization";

	private TokenAPI() {
		//
	}

	public static String createBearerSchema(User usuario) {
		return createBearerSchema(usuario, true);
	}

	public static String createBearerSchema(User usuario, boolean expire) {
		return BEARER + generateAuthToken(usuario, expire);
	}

	public static String generateAuthToken(User user) {
		return generateAuthToken(user, true);
	}

	public static String generateAuthToken(User user, boolean expire) {
		String accessToken = null;
		try {
			final Claims claims = Jwts.claims();
			if (expire) {
				// Por enquanto será valido sempre por 8 horas
				claims.setExpiration(
						Date.from(LocalDateTime.now().plusHours(8).atZone(ZoneId.systemDefault()).toInstant()));
			}
			claims.setSubject(user.getUsername());
			claims.setAudience(user.getApplicationId());
			claims.setIssuer(user.getSessionToken());
			claims.put(NAME, user.getName());
			claims.put(EMAIL, user.getEmail());

			accessToken = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, KEY_BYTES).compact();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	public static User loadUserInformation(String authToken) {
		if (!StringUtils.hasText(authToken)) {
			return null;
		}

		final Jws<Claims> parsed = Jwts.parser().setSigningKey(KEY_BYTES).parseClaimsJws(authToken);
		final Claims body = parsed.getBody();

		// Informações da pessoa autorizada
		final UserBuilder builder = new UserBuilder();
		builder.setUsername(body.getSubject());
		builder.setApplicationId(body.getAudience());
		builder.setSessionToken(body.getIssuer());
		builder.setName(body.get(NAME).toString());
		Object email = body.get(EMAIL);
		if (email != null) {
			builder.setEmail(email.toString());
		}

		return builder.build();
	}

	public static User getUserFromRequest(HttpServletRequest request) {
		final String token = getAuthorization(request);
		return loadUserInformation(getAuthToken(token));
	}

	public static User getUserFromToken(String authToken) {
		return loadUserInformation(authToken);
	}

	public static String getAuthorization(HttpServletRequest httpRequest) {
		final String token = httpRequest.getHeader(AUTHORIZATION);
		if (token != null) {
			return token;
		}

		final Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (final Cookie cookie : cookies) {
				if (AUTHORIZATION.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	public static Cookie createCookie(String headerValue) {
		final Cookie cookie = new Cookie(AUTHORIZATION, headerValue);
		cookie.setPath("/");
		return cookie;
	}

	private static String getAuthToken(String authHeader) {
		if (StringUtils.hasText(authHeader)) {
			final String value = authHeader.replaceAll("\"", "");
			if (value.startsWith(BEARER) && value.length() > BEARER.length()) {
				return value.substring(BEARER.length(), value.length());
			}
		}
		return null;
	}

}
