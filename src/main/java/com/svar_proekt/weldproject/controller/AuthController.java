package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.AdminDTO;
import com.svar_proekt.weldproject.enums.Role;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/login")
    public String getFormLogin() {
        return "login";
    }

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("adminDTO") AdminDTO adminDTO, Model model) {
        model.addAttribute("roles", Role.values());
        return "registration";
    }


}
