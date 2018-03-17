package ca.skip.api.config.security;

import java.util.HashSet;
import java.util.Set;

public class UserBuilder {

	private String username;
	private String name;
	private String email;
	private Set<String> profiles;
	private String sessionToken;
	private String applicationId;

	public UserBuilder() {
		profiles = new HashSet<>();
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder addProfile(String profile) {
		this.profiles.add(profile);
		return this;
	}

	public UserBuilder setProfiles(Set<String> profiles) {
		this.profiles = profiles;
		return this;
	}

	public UserBuilder setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
		return this;
	}

	public UserBuilder setApplicationId(String applicationId) {
		this.applicationId = applicationId;
		return this;
	}

	public User build() {
		return new User(username, name, email, sessionToken, applicationId);
	}

}
