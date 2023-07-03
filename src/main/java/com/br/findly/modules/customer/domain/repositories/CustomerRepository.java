package com.br.findly.modules.customer.domain.repositories;

import com.br.findly.modules.customer.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
