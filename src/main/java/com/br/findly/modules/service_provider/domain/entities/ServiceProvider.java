package com.br.findly.modules.service_provider.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;
    private String password;
    private String email;
    private String phone;
    private String cnpj;
    private String avatar;
    private String cpf;
    private String birthDate;

    public ServiceProvider(@NotBlank String name, @NotBlank @Size(min = 6, message = "Password must be at least 6 characters") String password, @NotBlank @Email String email, @NotBlank String phone, @NotBlank String cnpj, @NotBlank String cpf, @NotBlank @Pattern(regexp = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$", message = "Birth date must be in the format dd/MM/yyyy") String birthDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    @Deprecated

    public ServiceProvider() {
    }

    public UUID getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCpf() {
        return cpf;
    }
}
