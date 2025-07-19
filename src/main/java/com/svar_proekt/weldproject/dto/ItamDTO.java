package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.ProductionObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItamDTO {

    private int id;

    private String name;

    private ProductionObjectDTO productionObjectDTO;

    private Integer orderId;


}

