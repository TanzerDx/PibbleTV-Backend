package com.pibbletv.follows_service.business.converters;

import com.pibbletv.follows_service.domain.Following;
import com.pibbletv.follows_service.persistance.entities.FollowingEntity;

public final class FollowingConverter {

    private FollowingConverter() {
        throw new IllegalStateException("Following converter");
    }

    public static Following convertToObject(FollowingEntity entity) {
        if (entity == null) return null;

        return Following.builder()
                .id(entity.getId())
//                .follower(UserConverter.convertToObject(entity.getFollower()))
//                .followed(UserConverter.convertToObject(entity.getFollowed()))
                .build();
    }

    public static FollowingEntity convertToEntity(Following following) {
        if (following == null) return null;

        return FollowingEntity.builder()
                .id(following.getId())
//                .follower(UserConverter.convertToEntity(following.getFollower()))
//                .followed(UserConverter.convertToEntity(following.getFollowed()))
                .build();
    }
}
