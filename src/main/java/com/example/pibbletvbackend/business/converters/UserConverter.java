package com.example.pibbletvbackend.business.converters;

import com.example.pibbletvbackend.domain.User;
import com.example.pibbletvbackend.persistance.entities.UserEntity;

import java.util.Base64;

public final class UserConverter {

    private UserConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static User convertToObject(UserEntity entity) {
        if (entity == null) return null;

        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .role(entity.getRole())
                .bgImage(entity.getBgImage() != null ? Base64.getEncoder().encodeToString(entity.getBgImage()) : null)
                .profileImage(entity.getProfileImage() != null ? Base64.getEncoder().encodeToString(entity.getProfileImage()) : null)
                .isBanned(entity.getIsBanned())
                .build();
    }

    public static UserEntity convertToEntity(User user) {
        if (user == null) return null;

        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .bgImage(user.getBgImage() != null ? Base64.getDecoder().decode(user.getBgImage()) : null)
                .profileImage(user.getProfileImage() != null ? Base64.getDecoder().decode(user.getProfileImage()) : null)
                .isBanned(user.getIsBanned())
                .build();
    }

}