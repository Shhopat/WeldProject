package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.dto.WorkerDTO;
import com.svar_proekt.weldproject.enums.Position;
import com.svar_proekt.weldproject.mapper.ForemanMapper;
import com.svar_proekt.weldproject.mapper.WorkerMapper;
import com.svar_proekt.weldproject.services.ForemanService;
import com.svar_proekt.weldproject.services.WorkerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {
    private int idForeman;
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;
    private final ForemanService foremanService;
    private final ForemanMapper foremanMapper;


    @GetMapping("/foreman/{id}/add")
    public String getFormWorker(@ModelAttribute("workerDTO") WorkerDTO workerDTO, Model model,
                                @PathVariable("id") int idForeman) {
        this.idForeman = idForeman;
        model.addAttribute("positions", Position.values());
        return "formWorker";

    }

    @PostMapping("/save")
    public String registerWorker(@ModelAttribute("workerDTO") @Valid WorkerDTO workerDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("positions", Position.values());
            return "formWorker";

        }
        System.out.println("save workerDTO.id " + workerDTO.getId());
        workerService.save(workerMapper.toEntity(workerDTO), idForeman);
        return "redirect:/foreman/" + idForeman;

    }

    @GetMapping("/{id}")
    public String getWorkerById(@PathVariable("id") int id, Model model) {
        model.addAttribute("workerDTO", workerMapper.toDTO(workerService.findById(id)));
        return "workerId";

    }

    @GetMapping("/{id}/editForm")
    public String getEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("workerDTO", workerMapper.toDTO(workerService.findById(id)));
        model.addAttribute("positions", Position.values());
        return "editWorkerForm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("workerDTO") @Valid WorkerDTO workerDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("positions", Position.values());
            return "editWorkerForm";
        }
        workerService.update(workerMapper.toEntity(workerDTO));
        return "redirect:/worker/" + workerDTO.getId();
    }


}
