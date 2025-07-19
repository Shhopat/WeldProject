package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.Foreman;
import com.svar_proekt.weldproject.model.Itam;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductionObjectDTO {
    public ProductionObjectDTO(String name) {
        this.name = name;
    }

    private int id;

    @Size(message = "name should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "name not be empty")
    private String name;

    @Size(message = "address should be between 5 - 200", min = 5, max = 200)
    @NotEmpty(message = "address not be empty")
    private String address;

    @Size(message = "postcode should be between 5 - 20", min = 5, max = 20)
    @NotEmpty(message = "postcode not be empty")
    private String postcode;

    private AdminDTO adminDTO;


    private List<ForemanDTO> foremanDTOList;

    private List<ItamDTO> itamDTOList;

    private List<OrderDTO> ordersDTOList;


}
