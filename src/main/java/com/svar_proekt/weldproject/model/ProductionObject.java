package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "object")
public class ProductionObject {

    public ProductionObject() {
    }

    public ProductionObject(int id, String name, String address, String postcode, Admin admin, List<Foreman> foremanList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.admin = admin;
        this.foremanList = foremanList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    @Size(message = "name should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "name not be empty")
    private String name;

    @Column(name = "address", length = 200, nullable = false)
    @Size(message = "address should be between 5 - 200", min = 5, max = 200)
    @NotEmpty(message = "address not be empty")
    private String address;

    @Column(name = "postcode", nullable = false, unique = true)
    @Size(message = "postcode should be between 5 - 20", min = 5, max = 20)
    @NotEmpty(message = "postcode not be empty")
    private String postcode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

    @OneToMany(mappedBy = "productionObject", fetch = FetchType.EAGER)
    private List<Foreman> foremanList;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Foreman> getForemanList() {
        return foremanList;
    }

    public void setForemanList(List<Foreman> foremanList) {
        this.foremanList = foremanList;
    }
}
