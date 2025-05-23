package com.svar_proekt.weldproject.model;

import com.svar_proekt.weldproject.enums.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    public Admin() {
    }

    public Admin(int id, String username, String password, Role role, List<ProductionObject> productionOjectsList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.objectList = productionOjectsList;
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

    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
    private List<ProductionObject> objectList;

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

    public List<ProductionObject> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<ProductionObject> objectList) {
        this.objectList = objectList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}