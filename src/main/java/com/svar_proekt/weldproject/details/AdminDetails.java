package com.svar_proekt.weldproject.details;

import com.svar_proekt.weldproject.model.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AdminDetails implements UserDetails {
    private Admin admin;

    public AdminDetails(Admin admin) {
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getName();
    }
}
