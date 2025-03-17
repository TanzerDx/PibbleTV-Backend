package com.example.pibbletvbackend.persistance.entities;

import com.example.pibbletvbackend.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_following")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FollowingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_user_id", nullable = false)
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "followed_user_id", nullable = false)
    private UserEntity followed;
}
