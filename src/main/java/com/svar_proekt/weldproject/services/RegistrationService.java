package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.repositories.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminDetailService adminDetailService;

    public RegistrationService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, AdminDetailService adminDetailService) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.adminDetailService = adminDetailService;
    }

    @Transactional
    public void register(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }

    @Transactional
    public void update(Admin admin) {
        System.out.println("username и  id из формы " + admin.getUsername() + " " + admin.getId());

        try {
            Admin admin1 = adminDetailService.findById(admin.getId());
            System.out.println("username из бд" + admin1.getUsername());
            admin1.setRole(admin.getRole());
            admin1.setUsername(admin.getUsername());
            if (!passwordEncoder.matches(admin.getPassword(), admin1.getPassword())) {
                admin1.setPassword(passwordEncoder.encode(admin.getPassword()));
            }
            System.out.println("username перед обновлеием " + admin1.getUsername());
            adminRepository.save(admin1);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
