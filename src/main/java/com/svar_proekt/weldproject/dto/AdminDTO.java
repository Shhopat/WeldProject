package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.enums.Role;
import com.svar_proekt.weldproject.model.ProductionObject;
import jakarta.persistence.*;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    private String username;

    @Column(name = "password", length = 100, unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "adminDTO", fetch = FetchType.EAGER)
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
