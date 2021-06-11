package com.omnirio.catalogapplication.service.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.omnirio.catalogapplication.builder.cateegory.CategoryWSBuilder;
import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.repository.category.CategoryRepository;
import com.omnirio.catalogapplication.ws.category.CategoryWS;

@Component
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryWSBuilder categoryWSBuilder;

	@Override
	@Transactional
	public CategoryWS createCategory(CategoryWS categoryWS) {
		Category category = categoryWSBuilder.categoryWSToEntityBuilder(categoryWS);
		Category savedCategory = categoryRepository.save(category);
		return categoryWSBuilder.categoryEntityToWSBuilder(savedCategory);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CategoryWS> getCategoryById(Long categoryId) {
		Optional<Category> savedCategory = categoryRepository.findById(categoryId);
		return savedCategory.isPresent() ? Optional.ofNullable(categoryWSBuilder.categoryEntityToWSBuilder(savedCategory.get())) : Optional.empty();
	}
}
