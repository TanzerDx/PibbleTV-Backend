package com.example.pibbletvbackend.business.implementations;

import com.example.pibbletvbackend.business.converters.CategoryConverter;
import com.example.pibbletvbackend.business.interfaces.CategoryService;
import com.example.pibbletvbackend.domain.Category;
import com.example.pibbletvbackend.persistance.jpa.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryConverter::convertToObject)
                .toList();
    }
}
