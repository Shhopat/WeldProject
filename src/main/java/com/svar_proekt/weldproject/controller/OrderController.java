package com.svar_proekt.weldproject.controller;

import com.svar_proekt.weldproject.mapper.OrderMapper;
import com.svar_proekt.weldproject.mapper.ProductionObjectMapper;
import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.services.ProductionObjectService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final ProductionObjectService productionObjectService;
    private final ProductionObjectMapper productionObjectMapper;
    private final OrderMapper orderMapper;

    @GetMapping("/objectDTO/{id}")
    public String getAllOrders(@PathVariable("id") int idObject, Model model) {
        ProductionObject productionObject = productionObjectService.findById(idObject);
        model.addAttribute("object",
                productionObjectMapper.toDTO(productionObject));
        model.addAttribute("orders", orderMapper.toDTOList(productionObject.getOrdersList()));
        return "allOrders";
    }
}
