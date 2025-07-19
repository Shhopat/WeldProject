package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JointDTO {

    private int id;


    private int count;


    private String name;


    private double thickeness;


    private int diameter;


    private double length;


    private String request;


    private ForemanDTO foremanDTO;
}
