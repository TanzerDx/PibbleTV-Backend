package com.example.pibbletvbackend.business.converters;

import com.example.pibbletvbackend.domain.Category;
import com.example.pibbletvbackend.persistance.entities.CategoryEntity;

import java.util.Base64;

public final class CategoryConverter {

    private CategoryConverter() {
        throw new IllegalStateException("Concert converter");
    }

    public static Category convertToObject(CategoryEntity entity)
    {
        if (entity == null) return null;

        return Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .image(entity.getImage() != null ? Base64.getEncoder().encodeToString(entity.getImage()) : null)
                .build();
    }

    public static CategoryEntity convertToEntity(Category category) {
        if (category == null) return null;

        return CategoryEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage() != null ? Base64.getDecoder().decode(category.getImage()) : null)
                .build();
    }
}
