package com.omnirio.catalogapplication.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.catalogapplication.model.category.CategoryAttributes;

@Repository
public interface CategoryAttributesRepository extends JpaRepository<CategoryAttributes, Long> {
}
