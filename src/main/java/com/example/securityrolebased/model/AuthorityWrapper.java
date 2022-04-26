package com.example.securityrolebased.model;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityWrapper implements GrantedAuthority {

    private String authority;

    public void setAuthority(Role role) {
        authority = "ROLE_" + role.getAuthority();
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
