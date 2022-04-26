package com.example.securityrolebased.service;

import com.example.securityrolebased.model.AppUser;
import com.example.securityrolebased.repository.AppUserRepo;
import com.example.securityrolebased.security.CustomSecurityAppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepo appUserRepo;

    @Autowired
    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findByName(username);

        if (user == null) {
            throw new UsernameNotFoundException(username + " not found!!");
        }

        return new CustomSecurityAppUser(user);
    }
}
