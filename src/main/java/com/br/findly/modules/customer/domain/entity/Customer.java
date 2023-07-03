package com.br.findly.modules.customer.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Customer {
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public Customer(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    @Deprecated
    public Customer() {
    }
}
