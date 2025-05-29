package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.AdminDTO;
import com.svar_proekt.weldproject.enums.Role;
import com.svar_proekt.weldproject.mapper.AdminMapper;
import com.svar_proekt.weldproject.services.AdminDetailService;
import com.svar_proekt.weldproject.services.RegistrationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.security.Principal;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AdminMapper adminMapper;
    private final RegistrationService registrationService;
    private final AdminDetailService adminDetailService;


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
    public String save(@ModelAttribute("adminDTO") @Valid AdminDTO adminDTO,
                       BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField() + " - " + fieldError.getDefaultMessage());
            }
            model.addAttribute("roles", Role.values());
            return "registration";
        }
        registrationService.register(adminMapper.toEntity(adminDTO));
        return "redirect:/auth/login?registered";
    }

    @GetMapping("/editForm/{id}")
    public String editForm(@PathVariable("id") int id, Model model) {
        System.out.println("EditForm id" + id);
        model.addAttribute("adminDTO",
                adminMapper.toDTO(adminDetailService.findById(id)));
        model.addAttribute("roles", Role.values());
        return "editFormAdmin";

    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("adminDTO") @Valid AdminDTO adminDTO, BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField() + " - " + fieldError.getDefaultMessage());
            }
            model.addAttribute("roles", Role.values());
            return "editFormAdmin";

        }
        System.out.println("id adminDTO edit" + adminDTO.getId());
        registrationService.update(adminMapper.toEntity(adminDTO));
        return "redirect:/auth/login";
    }


}
