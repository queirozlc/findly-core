package com.br.findly.modules.customer.infra.dtos.request;

import com.br.findly.modules.customer.domain.entity.Customer;
import com.br.findly.shared.validators.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CustomerRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    @UniqueValue(domainClass = Customer.class, fieldName = "email", message = "This email already exists")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @NotBlank(message = "Birth date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Birth date must be in the format yyyy-MM-dd")
    private String birthDate;

    public Customer build() {
        var parsedBirthDate = LocalDate.parse(this.birthDate);
        return new Customer(name, email, password, parsedBirthDate);
    }
}
