package com.br.findly.modules.service_provider.infra.dto.requests;

import com.br.findly.modules.service_provider.domain.entities.ServiceProvider;
import com.br.findly.shared.validators.IsOlderThan;
import com.br.findly.shared.validators.UniqueValue;
import com.br.findly.shared.validators.ValidateOneNotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
@ValidateOneNotNull(fields = {"cnpj", "cpf"})
public class CreateServiceProviderRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    @UniqueValue(domainClass = ServiceProvider.class, fieldName = "email", message = "This email already exists")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @UniqueValue(domainClass = ServiceProvider.class, fieldName = "cpf", message = "Invalid CNPJ")
    private String cnpj;

    @UniqueValue(domainClass = ServiceProvider.class, fieldName = "cpf", message = "Invalid CPF")
    private String cpf;

    @NotBlank(message = "Birth date is required")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Birth date must be in the format yyyy-MM-dd")
    @IsOlderThan(value = 18)
    private String birthDate;


    public ServiceProvider toModel() {
        return new ServiceProvider(name, password, email, phone, cnpj, cpf, birthDate);
    }
}
