package com.bank.ega.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numeroCompte;

    @Enumerated(EnumType.STRING)
    private TypeCompte typeCompte;

    private LocalDateTime dateCreation;

    private Double solde = 0.0;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "compteSource")
    private List<Transaction> transactionsSortantes;

    @OneToMany(mappedBy = "compteDestination")
    private List<Transaction> transactionsEntrantes;
}