package com.omnirio.catalogapplication.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.catalogapplication.model.category.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
