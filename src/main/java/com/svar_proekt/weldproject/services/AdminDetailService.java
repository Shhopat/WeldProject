package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.details.AdminDetails;
import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.repositories.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminDetailService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public AdminDetailService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> optionalAdmin = adminRepository.findByName(username);
        if (optionalAdmin.isEmpty()) {
            throw new UsernameNotFoundException("Username not found!");
        }
        return new AdminDetails(optionalAdmin.get());
    }
}
