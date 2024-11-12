package com.launderup.LaunderUp_Backend.repository;

import com.launderup.LaunderUp_Backend.models.Partner;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PartnerRepository extends ReactiveCrudRepository<Partner,Long> {

}
