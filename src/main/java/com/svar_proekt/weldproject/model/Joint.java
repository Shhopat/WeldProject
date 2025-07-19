package com.svar_proekt.weldproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "joint")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Joint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "thickeness", nullable = false)
    private double thickeness;

    @Column(name = "diameter", nullable = true)
    private int diameter;

    @Column(name = "length", nullable = true)
    private double length;

    @Column(name = "request", nullable = false, length = 50)
    private String request;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foreman_id", referencedColumnName = "id")
    private Foreman foreman;


}