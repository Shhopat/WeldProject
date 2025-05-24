package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.AdminDTO;
import com.svar_proekt.weldproject.enums.Role;
import com.svar_proekt.weldproject.mapper.AdminMapper;
import com.svar_proekt.weldproject.services.AdminDetailService;
import com.svar_proekt.weldproject.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AdminMapper adminMapper;
    private final RegistrationService registrationService;
    private final AdminDetailService adminDetailService;

    public AuthController(AdminMapper adminMapper, RegistrationService registrationService, AdminDetailService adminDetailService) {
        this.adminMapper = adminMapper;
        this.registrationService = registrationService;
        this.adminDetailService = adminDetailService;
    }

    @GetMapping("/login")
    public String getFormLogin() {
        return "login";
    }

    @GetMapping("/hello")
    public String getHello(Principal principal, Model model) {
        model.addAttribute("adminDTO", adminMapper
                .toDTO(adminDetailService.findByUsername(principal.getName())));
        return "hello";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("adminDTO") AdminDTO adminDTO, Model model) {
        model.addAttribute("roles", Role.values());
        return "registration";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("adminDTO") AdminDTO adminDTO) {
        registrationService.register(adminMapper.toEntity(adminDTO));
        return "redirect:/auth/login?registered";
    }


}
