package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.services.AdminDetailService;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/object")
@RequiredArgsConstructor
public class ProductionOjectsController {
    private final @Lazy ProductionObjectService productionObjectService;
    private final AdminDetailService adminDetailService;
    private final ProductionObjectMapper productionObjectMapper;


    @GetMapping("/all")
    public String getAllProductionObjects(Principal principal, Model model) {
        model.addAttribute("objectDTOList", productionObjectMapper.toDTOList(adminDetailService
                .getObjectsByUsername(
                        principal.getName())));
        return "objects";

    }

    @GetMapping("/add")
    public String getFormObject(@ModelAttribute("objectDTO") ProductionObjectDTO productionObjectDTO) {
        return "formObject";
    }

    @PostMapping("/save")
    public String creteObject(@ModelAttribute("objectDTO") @Valid ProductionObjectDTO productionObjectDTO
            , BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField() + " - " + fieldError.getDefaultMessage());
            }
            return "formObject";
        }
        productionObjectService.save(productionObjectMapper.toEntity(productionObjectDTO),
                adminDetailService.findByUsername(principal.getName()));
        return "redirect:/object/all";

    }

    @GetMapping("/{id}/edit")
    public String getEditObjectForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("objectDTO",
                productionObjectMapper.toDTO(productionObjectService.findById(id)));
        return "editObjectFrom";
    }

    @PostMapping("/edit/admin/{id}")
    public String updateObject(@ModelAttribute("objectDTO") @Valid ProductionObjectDTO productionObjectDTO
            , BindingResult bindingResult, @PathVariable("id") int adminId) {
        System.out.println(productionObjectDTO.getAdminDTO().getUsername());
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField() + " - " + fieldError.getDefaultMessage());
            }
            return "editObjectFrom";
        }
        productionObjectService.update(productionObjectMapper.toEntity(productionObjectDTO),
                adminDetailService.findById(adminId));
        return "redirect:/object/all";
    }


}

