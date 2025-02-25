package com.example.pibbletvbackend.business.interfaces;

import com.example.pibbletvbackend.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
}
