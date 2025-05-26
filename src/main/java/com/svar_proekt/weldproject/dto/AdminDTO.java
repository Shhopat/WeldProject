package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.enums.Role;
import com.svar_proekt.weldproject.model.ProductionObject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AdminDTO {

    public AdminDTO() {
    }

    public AdminDTO(int id, String name, String password, Role role, List<ProductionObject> productionOjectsList) {
        this.id = id;
        this.username = name;
        this.password = password;
        this.role = role;
        this.objectDTOList = productionOjectsList;
    }

    private int id;


    @Size(message = "username should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "username not be empty")
    private String username;

    @Size(message = "password should be between 8 - 100", min = 8, max = 100)
    @NotEmpty(message = "password not be empty")
    private String password;


    private Role role;

    private List<ProductionObject> objectDTOList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<ProductionObject> getObjectDTOList() {
        return objectDTOList;
    }

    public void setObjectDTOList(List<ProductionObject> objectDTOList) {
        this.objectDTOList = objectDTOList;
    }
}
