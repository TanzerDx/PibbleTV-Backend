package com.example.pibbletvbackend.persistance.jpa;

import com.example.pibbletvbackend.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT f.followed FROM FollowingEntity f WHERE f.follower.id = :userId")
    List<UserEntity> findFollowing(@Param("userId") Long userId);

    @Query("SELECT f.follower FROM FollowingEntity f WHERE f.followed.id = :userId")
    List<UserEntity> findFollowers(@Param("userId") Long userId);

}
