package com.example.pibbletvbackend.persistance.entities;

import com.example.pibbletvbackend.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;

    @NotEmpty(message = "Username is required")
    @Length(min = 3, max = 17, message = "Username must be between 3 and 17 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String role;

    @Lob
    private byte[] bgImage;

    @Lob
    private byte[] profileImage;

    @Column(nullable = false)
    private Boolean isBanned = false;

}
