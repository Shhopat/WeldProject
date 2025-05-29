package com.svar_proekt.weldproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionExceptionDTO {
    private String ms;
    private LocalTime localTime;

}

