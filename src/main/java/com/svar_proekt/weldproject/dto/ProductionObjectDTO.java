package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;

import java.util.List;

public class ProductionObjectDTO {
    public ProductionObjectDTO() {
    }

    public ProductionObjectDTO(int id, String name, String address, int postcode, AdminDTO adminDTO, List<ForemanDTO> foremanDTOList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.adminDTO = adminDTO;
        this.foremanDTOList = foremanDTOList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "postcode", nullable = false, unique = true)
    private int postcode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private AdminDTO adminDTO;

    @OneToMany(mappedBy = "productionObjectDTO", fetch = FetchType.EAGER)
    private List<ForemanDTO> foremanDTOList;

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

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public AdminDTO getAdminDTO() {
        return adminDTO;
    }

    public void setAdminDTO(AdminDTO adminDTO) {
        this.adminDTO = adminDTO;
    }

    public List<ForemanDTO> getForemanDTOList() {
        return foremanDTOList;
    }

    public void setForemanDTOList(List<ForemanDTO> foremanDTOList) {
        this.foremanDTOList = foremanDTOList;
    }
}
