package com.launderup.LaunderUp_Backend.repository;

import com.launderup.LaunderUp_Backend.models.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CustomerAddressRepository extends ReactiveCrudRepository<Address, Long> {
    Flux<Address> findByCustomerId(String customerId);
}
