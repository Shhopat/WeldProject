package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.ProductionObject;
import com.svar_proekt.weldproject.model.Worker;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForemanDTO {
    private int id;

    @NotEmpty(message = "name not be empty")
    @Size(message = "name should be between 3 - 40", min = 3, max = 40)
    private String name;

    @NotEmpty(message = "info not be empty")
    @Size(message = "info should be between 3 - 40", min = 3, max = 200)
    private String info;

    private ProductionObjectDTO productionObjectDTO;

    private List<WorkerDTO> workerDTOList;


}
