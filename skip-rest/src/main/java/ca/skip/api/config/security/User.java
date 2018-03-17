package ca.skip.api.config.security;

import java.util.Objects;

public class User {

	private final String username;
	private final String name;
	private final String email;
	private final String sessionToken;
	private final String applicationId;

	public User(String username, String name, String email, String sessionToken, String applicationId) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.sessionToken = sessionToken;
		this.applicationId = applicationId;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;

		return Objects.equals(username, other.username);
	}

	public String getApplicationId() {
		return this.applicationId;
	}

}
