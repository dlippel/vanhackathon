package ca.skip.api.config.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {

	private static final long serialVersionUID = 1L;

	public static final boolean AUTHENTICATE = true;

	private final User user;

	public UserAuthentication(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// return AuthorityUtils.createAuthorityList(this.user.getProfiles().toArray(new
		// String[this.user.getProfiles().size()]));
		return Collections.emptyList();
	}

	@Override
	public Object getDetails() {
		return this.user;
	}

	@Override
	public Object getPrincipal() {
		return this.user;
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@Override
	public String getName() {
		return this.user.getUsername();
	}

	@Override
	public Object getCredentials() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
