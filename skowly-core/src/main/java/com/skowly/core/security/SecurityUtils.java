package com.skowly.core.security;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class SecurityUtils {

	private SecurityUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Fetch the current authenticated user's username.
	 *
	 * @return username of the authenticated user, null if no authentication exists.
	 */
	public static String getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
			return (String) jwtAuthenticationToken.getTokenAttributes().get("preferred_username");
		}
		return null;
	}

	/**
	 * Fetch the roles of the currently authenticated user.
	 *
	 * @return list of roles, empty list if no roles or no authentication.
	 */
	public static List<String> getCurrentUserRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			return authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		}
		return List.of();
	}

	/**
	 * Fetch a specific attribute from the JWT token of the currently authenticated
	 * user.
	 *
	 * @param attributeName the name of the attribute to fetch.
	 * @return The attribute value or null if the attribute doesn't exist or there's
	 *         no authentication.
	 */
	public static Object getTokenAttribute(String attributeName) {
		return getTokenAttributes().get(attributeName);
	}

	/**
	 * Fetch attributes from the JWT token of the currently authenticated user.
	 *
	 * @return map of token attributes, empty map if no authentication or not
	 *         JwtAuthenticationToken.
	 */
	public static Map<String, Object> getTokenAttributes() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof JwtAuthenticationToken jwtAuthenticationToken) {
			return jwtAuthenticationToken.getTokenAttributes();
		}
		return Map.of();
	}
}
