package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.enums.Position;
import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {
    private int id;

    @NotEmpty(message = "name not be empty")
    @Size(min = 4, max = 40, message = "name should be between 4-40")
    private String name;

    private Position position;

    private ForemanDTO foremanDTO;

    public String getPositionString() {
        return this.position.getDisplayName();
    }


}
