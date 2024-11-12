package com.launderup.LaunderUp_Backend.repository;

import com.launderup.LaunderUp_Backend.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {
}
