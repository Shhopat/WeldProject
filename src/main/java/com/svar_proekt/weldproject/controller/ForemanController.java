package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.ForemanDTO;
import com.svar_proekt.weldproject.mapper.AdminMapper;
import com.svar_proekt.weldproject.mapper.ForemanMapper;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.mapper.WorkerMapper;
import com.svar_proekt.weldproject.services.ForemanService;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/foreman")
public class ForemanController {
    private final ForemanMapper foremanMapper;
    private final ForemanService foremanService;
    private final ProductionObjectMapper productionObjectMapper;
    private final ProductionObjectService productionObjectService;
    private final WorkerMapper workerMapper;

    @Autowired
    public ForemanController(ForemanMapper foremanMapper, ForemanService foremanService, ProductionObjectMapper productionObjectMapper, ProductionObjectService productionObjectService, WorkerMapper workerMapper) {
        this.foremanMapper = foremanMapper;
        this.foremanService = foremanService;
        this.productionObjectMapper = productionObjectMapper;
        this.productionObjectService = productionObjectService;
        this.workerMapper = workerMapper;
    }

    @GetMapping("/object/{id}/all")
    public String getAllForeman(@PathVariable("id") int id, Model model) {
        model.addAttribute("foremanDTOList", foremanMapper.toDTOLIst(productionObjectService.findById(id).getForemanList()));
        model.addAttribute("objectDTO", productionObjectMapper.toDTO(productionObjectService.findById(id)));
        return "allForeman";

    }

    @GetMapping("/object/{id}/getForm")
    public String getForemanForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("objectDTO", productionObjectMapper.toDTO(productionObjectService.findById(id)));
        model.addAttribute("foremanDTO", new ForemanDTO());
        return "formForeman";

    }

    @PostMapping("/object/{id}/save")
    public String registerForeman(@PathVariable("id") int id, @ModelAttribute("foremanDTO") @Valid ForemanDTO foremanDTO,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("objectDTO", productionObjectMapper.toDTO(productionObjectService.findById(id)));
            return "formForeman";
        }
        System.out.println(" save ForemanDTO " + foremanDTO.getId());
        foremanService.save(foremanMapper.toEntity(foremanDTO), id);
        return "redirect:/foreman/object/" + id + "/all";
    }

    @GetMapping("/{id}")
    public String getForemanById(@PathVariable("id") int id, Model model) {
        ForemanDTO foremanDTO = foremanMapper.toDTO(foremanService.findById(id));
        model.addAttribute("foremanDTO", foremanDTO);
        model.addAttribute("workerDTOList", workerMapper.toDTOList(foremanService.findById(id).getWorkerList()));
        System.out.println(foremanService.findById(id).getWorkerList());
        System.out.println(foremanDTO.getId());

        return "foremanIdAndAllWorkers";
    }

    @GetMapping("/{id}/edit")
    public String getEditForemanForm(@PathVariable("id") int id, Model model) {
        System.out.println("пришел в editForeman");
        model.addAttribute("foremanDTO", foremanMapper.toDTO(foremanService.findById(id)));
        return "editForeman";
    }

    @PostMapping("/update")
    public String editForeman(@ModelAttribute("foremanDTO") @Valid ForemanDTO foremanDTO,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editForeman";
        }
        System.out.println(foremanService.findById(foremanDTO.getId()).getProductionObject().getName());
        foremanService.update(foremanMapper.toEntity(foremanDTO));
        return "redirect:/foreman/" + foremanDTO.getId();

    }
}
