package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.Admin;
import com.svar_proekt.weldproject.model.Foreman;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ProductionObjectDTO {
    public ProductionObjectDTO() {
    }

    public ProductionObjectDTO(int id, String name, String address, String postcode, AdminDTO adminDTO, List<ForemanDTO> foremanDTOList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postcode = postcode;
        this.adminDTO = adminDTO;
        this.foremanDTOList = foremanDTOList;
    }


    private int id;


    @Size(message = "name should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "name not be empty")
    private String name;


    @Size(message = "address should be between 5 - 200", min = 5, max = 200)
    @NotEmpty(message = "address not be empty")
    private String address;


    @Size(message = "postcode should be between 5 - 20", min = 5, max = 20)
    @NotEmpty(message = "postcode not be empty")
    private String postcode;

    private AdminDTO adminDTO;


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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
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
