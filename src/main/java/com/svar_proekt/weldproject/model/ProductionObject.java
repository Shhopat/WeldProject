package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "object")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductionObject {
    public ProductionObject(int id, String name) {
        this.id = id;
        this.name = name;
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

    @OneToMany(mappedBy = "productionObject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Itam> itamList;

    @OneToMany(mappedBy = "productionObject", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> ordersList;


}
