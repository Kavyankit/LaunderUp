package com.launderup.LaunderUp_Backend.repository;

import com.launderup.LaunderUp_Backend.models.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Long> {
}
