package com.br.findly.modules.service_provider.infra.controllers;

import com.br.findly.modules.service_provider.domain.entities.Service;
import com.br.findly.modules.service_provider.domain.repositories.ServiceRepository;
import com.br.findly.modules.service_provider.infra.dto.requests.CreateServiceRequest;
import com.br.findly.shared.adapters.InMemoryUploader;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/service-provider")
@RequiredArgsConstructor
public class CreateServiceController {

    private final ServiceRepository serviceRepository;

    @PostMapping("/service")
    @ResponseStatus(HttpStatus.CREATED)
    public void handle(@RequestBody @Valid CreateServiceRequest request) {
        Service service = request.toEntity(new InMemoryUploader());
        serviceRepository.save(service);
    }
}
