package com.launderup.LaunderUp_Backend.repository;

import com.launderup.LaunderUp_Backend.models.LaunderupOrder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<LaunderupOrder, Long> {

    Flux<LaunderupOrder> findByCustomerIdOrderByOrderCreatedAtDesc(Long customerId);

    Flux<LaunderupOrder> findByPartnerIdOrderByOrderCreatedAtDesc(Long partnerId);
}
