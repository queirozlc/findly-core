package com.br.findly.modules.customer.infra.controllers;

import com.br.findly.modules.customer.domain.repositories.CustomerRepository;
import com.br.findly.modules.customer.infra.dtos.request.CustomerRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CreateCustomerController {
    private final CustomerRepository customerRepository;

    public CreateCustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        var customerToSave = customerRequest.build();
        customerRepository.save(customerToSave);
        return ResponseEntity.ok().build();
    }
}
