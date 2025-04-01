package com.pibbletv.follows_service.persistance.repository;

import com.pibbletv.follows_service.persistance.entities.FollowingEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FollowingRepository extends ReactiveCrudRepository<FollowingEntity, Long> {
}
