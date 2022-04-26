package com.example.securityrolebased.controller;

import com.example.securityrolebased.model.AppUser;
import com.example.securityrolebased.model.Role;
import com.example.securityrolebased.model.RoleEnum;
import com.example.securityrolebased.repository.AppUserRepo;
import com.example.securityrolebased.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class RegisterController {

    private AppUserRepo appUserRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(AppUserRepo appUserRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/register")
    public AppUser register(@RequestBody AppUser user) {
        AppUser tmpUser = user;
        tmpUser.setPassword(passwordEncoder.encode(user.getPassword()));
        appUserRepo.save(tmpUser);

        Role role = new Role();
        role.setRoleEnum(RoleEnum.USER);
        role.setUser(tmpUser);
        roleRepo.save(role);

        return tmpUser;
    }
}
