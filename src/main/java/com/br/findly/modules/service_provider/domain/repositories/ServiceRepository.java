package com.br.findly.modules.service_provider.domain.repositories;

import com.br.findly.modules.service_provider.domain.entities.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ServiceRepository extends CrudRepository<Service, UUID> {
}
