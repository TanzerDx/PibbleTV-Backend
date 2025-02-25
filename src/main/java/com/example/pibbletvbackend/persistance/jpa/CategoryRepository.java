package com.example.pibbletvbackend.persistance.jpa;

import com.example.pibbletvbackend.persistance.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
