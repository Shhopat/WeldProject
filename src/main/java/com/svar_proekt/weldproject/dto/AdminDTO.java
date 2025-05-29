package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.enums.Role;
import com.svar_proekt.weldproject.model.ProductionObject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {
    private int id;
    @Size(message = "username should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "username not be empty")
    private String username;
    @Size(message = "password should be between 8 - 100", min = 8, max = 100)
    @NotEmpty(message = "password not be empty")
    private String password;

    private Role role;

    private List<ProductionObject> objectDTOList;


}
