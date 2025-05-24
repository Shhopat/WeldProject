package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.services.AdminDetailService;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/object")
public class ProductionOjectsController {
    private final ProductionObjectService productionObjectService;
    private final AdminDetailService adminDetailService;
    private final ProductionObjectMapper productionObjectMapper;

    public ProductionOjectsController(ProductionObjectService productionObjectService, AdminDetailService adminDetailService, ProductionObjectMapper productionObjectMapper) {
        this.productionObjectService = productionObjectService;
        this.adminDetailService = adminDetailService;
        this.productionObjectMapper = productionObjectMapper;
    }


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
    public String creteObject(@ModelAttribute("objectDTO") ProductionObjectDTO productionObjectDTO,
                              Principal principal) {
        productionObjectService.save(productionObjectMapper.toEntity(productionObjectDTO),
                adminDetailService.findByUsername(principal.getName()));
        return "redirect:/object/all";

    }
}

