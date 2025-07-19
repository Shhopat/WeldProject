package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.client.ItamClient;
import com.svar_proekt.weldproject.dto.ItamDTO;
import com.svar_proekt.weldproject.dto.ProductionObjectDTO;
import com.svar_proekt.weldproject.mapper.ItamMapper;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.model.Itam;
import com.svar_proekt.weldproject.services.ItamService;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/itam")
@RequiredArgsConstructor
@Slf4j
public class ItamController {
    private static final Logger logger = LoggerFactory.getLogger(ItamController.class);

    private final ItamMapper itamMapper;
    private final ItamService itamService;
    private final ProductionObjectService productionObjectService;
    private final ProductionObjectMapper productionObjectMapper;


    @GetMapping("/all/objectDTO/{id}")
    public String getAllItam(@PathVariable("id") int id, Model model) {
        ProductionObjectDTO productionObjectDTO = productionObjectMapper.toDTO(productionObjectService.findById(id));
        model.addAttribute("objectDTO", productionObjectDTO);
        model.addAttribute("itamDTOList", productionObjectDTO.getItamDTOList());

        return "AllItam";

    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<HttpStatus> saveItam(@RequestBody ItamDTO itamDTO) {
        Itam itam = itamMapper.toEntity(itamDTO);
        System.out.println("save" + itam.getProductionObject().getName());
        itamService.save(itam);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<ItamDTO>> listResponseEntity(@RequestParam("objectId") int idObject) {
        logger.info(" перешел в ItamController");

        return new ResponseEntity<>(itamMapper.itamDTOList(itamService.findAll(idObject)), HttpStatus.OK);

    }

    @GetMapping("/objectDTO/{id}/getForm")
    public String getFormItam(@PathVariable("id") int idObject, Model model) {
        model.addAttribute("itam", new ItamDTO());
        model.addAttribute("object", productionObjectMapper.toDTO(productionObjectService.findById(idObject)));
        return "formItam";
    }

    @PostMapping("/object/{id}/save")
    public String saveItam(@PathVariable("id") int idObject, @ModelAttribute("itam") Itam itam) {
        log.debug(itam.getName());
        productionObjectService.addItam(idObject, itam);
        log.debug("вышел  из addItam");
        return "redirect:/itam/all/objectDTO/" + idObject;

    }

}
