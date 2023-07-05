package com.br.findly.modules.service_provider.domain.repositories;

import com.br.findly.modules.service_provider.domain.entities.ServiceProvider;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ServiceProviderRepository extends CrudRepository<ServiceProvider, UUID> {
}