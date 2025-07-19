package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.model.Joint;
import com.svar_proekt.weldproject.services.ForemanService;
import com.svar_proekt.weldproject.services.JointService;
import com.svar_proekt.weldproject.services.ProductionObjectService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weld")
@RequiredArgsConstructor
@Slf4j
public class WeldController {
    private final ProductionObjectService productionObjectService;
    private final JointService jointService;


    @GetMapping("/{id}/form")
    public String getForm(@PathVariable("id") int id, Model model) {
        log.debug("в контролере Weld");

        model.addAttribute("foremanList", productionObjectService.findById(id).getForemanList());

        log.debug("после метода  productionObjectService.findById(id).getForemanList() ");

        model.addAttribute("joint", new Joint());

        log.debug("перед return");
        return "form_joint";
    }

    @PostMapping("/foreman/save")
    public void   save(@ModelAttribute("joint") Joint joint){
        log.debug("в методе save");
        log.debug("id foreman:{}",joint.getForeman().getId());
        jointService.save(joint);
    }


}
