package com.example.securityrolebased.security;

import com.example.securityrolebased.model.AppUser;
import com.example.securityrolebased.model.AuthorityWrapper;
import com.example.securityrolebased.model.Role;
import com.example.securityrolebased.model.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomSecurityAppUser extends AppUser implements UserDetails {

    private Set<String> stringRoles = new HashSet<>();
    private Set<AuthorityWrapper> authorityWrappers = new HashSet<>();
    private AuthorityWrapper wrapper;

    public CustomSecurityAppUser(AppUser user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setPassword(user.getPassword());
        this.setRoles(user.getRoles());
        wrapper = new AuthorityWrapper();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roleSet = this.getRoles();

        for (Role role: roleSet) {
            wrapper.setAuthority(role);
            authorityWrappers.add(wrapper);
        }
        return authorityWrappers;
    }

    @Override
    public String getUsername() {
        return this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<String> getStringRoles() {
        return stringRoles;
    }

    public void setStringRoles() {
        Set<Role> roleSet = getRoles();

        for (Role role: roleSet) {
            stringRoles.add(role.getAuthority());
        }
    }
}
