package com.skowly.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.skowly.core.security.SecurityRole;

@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Value("${keycloak.realm}") private String realm;
	
	@Autowired
	Keycloak keycloak;

	@Autowired
	EmailService emailService;
	
	
	

	public void createSchoolAdminUser(String username, String email, String schoolId) throws Exception {
		logger.info("CREATING USER IN KEYCLOAK: ", username);
		UserRepresentation user = new UserRepresentation();
		user.setUsername(username);
		user.setEmail(email);
		user.setEnabled(true);
		List<String> roles = new ArrayList<>();
		roles.add(SecurityRole.ROLE_ADMIN.getValue());
		user.setRealmRoles(roles);
		createRolesIfNotExist(realm, Arrays.asList(SecurityRole.values()).stream().map(e->e.getValue().replace("ROLE_", "")).toList());
		Map<String, List<String>> attributes = new HashMap<>();
		List<String> schoolIdAttribute = new ArrayList<>();
		schoolIdAttribute.add(schoolId);
		attributes.put("schoolId", schoolIdAttribute);
		user.setAttributes(attributes);
		CredentialRepresentation credentials = new CredentialRepresentation();
		credentials.setType(CredentialRepresentation.PASSWORD);
		credentials.setValue(username);
		credentials.setTemporary(true);
		user.setCredentials(Arrays.asList(credentials));
		javax.ws.rs.core.Response rsponse = keycloak.realm(realm).users().create(user);
		logger.info("HTTP STATUS FROM KEYCLOAK RESPONSE: ", rsponse.getStatus());
		if (201 != rsponse.getStatus() && 200 != rsponse.getStatus()) {
			throw new Exception("User creation failed");
		}
		emailService.sendEmail(email, "Scowly account", "Username=" + username + "password=" + username);

	}

	/**
	 * Create roles in Keycloak if they don't exist.
	 *
	 * @param realmName The name of the realm in Keycloak.
	 * @param roleNames A list of role names to create.
	 */
	public void createRolesIfNotExist(String realmName, List<String> roleNames) {
		logger.info("Creating roles in Keycloak if they don't exist for realm: {}", realmName);

		List<RoleRepresentation> existingRoles = keycloak.realm(realmName).roles().list();
		for (String roleName : roleNames) {
			boolean roleExists = existingRoles.stream().anyMatch(role -> role.getName().equals(roleName));
			if (!roleExists) {
				RoleRepresentation newRole = new RoleRepresentation();
				newRole.setName(roleName);
				keycloak.realm(realmName).roles().create(newRole);
				logger.info("Created role '{}' in realm '{}'", roleName, realmName);
			} else {
				logger.info("Role '{}' already exists in realm '{}'", roleName, realmName);
			}
		}
	}

}