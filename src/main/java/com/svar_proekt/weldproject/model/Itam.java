package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itam")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Itam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private ProductionObject productionObject;


}
