package com.svar_proekt.weldproject.model;

import com.svar_proekt.weldproject.enums.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    public Admin() {
    }

    public Admin(int id, String name, String password, Role role, List<ProductionObject> productionOjectsList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.productionOjectsList = productionOjectsList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "password", length = 100, unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
    private List<ProductionObject> productionOjectsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProductionObject> getProductionOjectsList() {
        return productionOjectsList;
    }

    public void setProductionOjectsList(List<ProductionObject> productionOjectsList) {
        this.productionOjectsList = productionOjectsList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}