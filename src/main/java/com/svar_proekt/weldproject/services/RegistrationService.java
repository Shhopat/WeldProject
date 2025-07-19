package com.svar_proekt.weldproject.services;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final AdminDetailService adminDetailService;


    @Transactional
    public void register(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
        log.debug("регистрация прошла");
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
