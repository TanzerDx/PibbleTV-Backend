package com.pibbletv.follows_service.persistance.jpa;

import com.pibbletv.follows_service.persistance.entities.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowingRepository extends JpaRepository<FollowingEntity, Long> {
}
