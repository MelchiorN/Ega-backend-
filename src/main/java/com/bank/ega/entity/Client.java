package com.bank.ega.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotNull
    private LocalDate dateNaissance;

    @NotBlank
    private String sexe;

    private String adresse;

    @Pattern(regexp = "^[0-9+ ]+$")
    private String telephone;

    @Email
    @Column(unique = true)
    private String email;

    private String nationalite;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Compte> comptes;

   
 
}
