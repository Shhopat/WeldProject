package com.svar_proekt.weldproject.model;

import com.svar_proekt.weldproject.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "admin")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    public Admin(int id, String username) {
        this.id = id;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 40, nullable = false)
    @Size(message = "username should be between 5 - 40", min = 5, max = 20)
    @NotEmpty(message = "username not be empty")
    private String username;

    @Column(name = "password", length = 100, unique = true, nullable = false)
    @Size(message = "password should be between 8 - 100", min = 8, max = 100)
    @NotEmpty(message = "password not be empty")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
    private List<ProductionObject> objectList;


}