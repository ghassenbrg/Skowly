package com.skowly.core.security;

public enum SecurityRole {

	ROLE_SKOWLY_ADMIN("ROLE_SKOWLY_ADMIN"),
	ROLE_ADMIN("ROLE_SCHOOL_ADMIN"),
	ROLE_STAFF("ROLE_STAFF"),
	ROLE_PARENT("ROLE_PARENT"),
	ROLE_STUDENT("ROLE_STUDENT"),
	ROLE_TEACHER("ROLE_TEACHER");

    private final String value;

    SecurityRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
