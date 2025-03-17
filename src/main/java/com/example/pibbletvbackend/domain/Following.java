package com.example.pibbletvbackend.domain;

import com.example.pibbletvbackend.persistance.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Following {

    private Long id;

    private User follower;

    private User followed;
}
