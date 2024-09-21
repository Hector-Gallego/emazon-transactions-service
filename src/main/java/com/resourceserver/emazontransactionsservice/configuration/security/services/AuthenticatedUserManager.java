package com.resourceserver.emazontransactionsservice.configuration.security.services;

import com.resourceserver.emazontransactionsservice.configuration.security.constants.SecurityConstants;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Map;

public class AuthenticatedUserManager implements AuthenticatedManagerPort {

    @Override
    public Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Map<String, Object> claims = ((JwtAuthenticationToken) authentication).getToken().getClaims();
        return (Long) claims.get(SecurityConstants.CLAIM_FIELD_NAME_USER_ID);
    }
}
