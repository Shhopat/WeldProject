package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.Itam;
import com.svar_proekt.weldproject.model.ProductionObject;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderDTO {
    private Integer id;
    private Integer objectId;
    private List<ItamDTO> itamDTOList;
}
