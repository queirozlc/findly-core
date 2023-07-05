package com.br.findly.modules.service_provider.infra.controllers;

import com.br.findly.modules.service_provider.domain.entities.ServiceProvider;
import com.br.findly.modules.service_provider.domain.repositories.ServiceProviderRepository;
import com.br.findly.modules.service_provider.infra.dto.requests.CreateServiceProviderRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/service-provider")
public class CreateServiceProviderController {

    private final ServiceProviderRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@RequestBody @Valid CreateServiceProviderRequest request) {
        System.out.println(request);
        ServiceProvider serviceProvider = request.toModel();
        repository.save(serviceProvider);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
