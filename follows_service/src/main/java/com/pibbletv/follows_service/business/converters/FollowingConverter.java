package com.pibbletv.follows_service.business.converters;

import com.pibbletv.follows_service.domain.Following;
import com.pibbletv.follows_service.persistance.entities.FollowingEntity;

public final class FollowingConverter {

    private FollowingConverter() {
        throw new IllegalStateException("Utility class");
    }

    public static Following convertToObject(FollowingEntity entity) {
        if (entity == null) return null;

        return Following.builder()
                .id(entity.getId())
                .followerId(entity.getFollowerId())
                .followedId(entity.getFollowedId())
                .build();
    }

    public static FollowingEntity convertToEntity(Following following) {
        if (following == null) return null;

        return FollowingEntity.builder()
                .id(following.getId())
                .followerId(following.getFollowerId())
                .followedId(following.getFollowedId())
                .build();
    }
}