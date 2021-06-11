package com.omnirio.catalogapplication.service.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.omnirio.catalogapplication.builder.cateegory.CategoryWSBuilder;
import com.omnirio.catalogapplication.builder.cateegory.attributes.CategoryAttributeWSBuilder;
import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.model.category.CategoryAttributes;
import com.omnirio.catalogapplication.repository.category.CategoryAttributesRepository;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.category.CategoryWS;

@Component
public class CategoryAttributeServiceImpl implements CategoryAttributeService{

	@Autowired
	private CategoryAttributesRepository categoryAttributesRepository;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryAttributeWSBuilder categoryAttributeWSBuilder;

	@Autowired
	private CategoryWSBuilder categoryWSBuilder;

	@Override
	@Transactional
	public List<CategoryAttributeWS> saveCategoryAttributes(Long categoryId, List<CategoryAttributeWS> categoryAttributeWS) {
		Optional<CategoryWS> categoryWS = categoryService.getCategoryById(categoryId);
		if(!categoryWS.isPresent())
			return new ArrayList<>();
		Category category = categoryWSBuilder.categoryWSToEntityBuilder(categoryWS.get());

		List<CategoryAttributes> categoryAttributes = categoryAttributeWS.stream()
				.map(attribute -> categoryAttributeWSBuilder.categoryAttributeWSToEntityBuilder(category, attribute))
				.collect(Collectors.toList());

		List<CategoryAttributes> savedAttributes = categoryAttributesRepository.saveAll(categoryAttributes);

		List<CategoryAttributeWS> saveddata = savedAttributes.stream()
				.map(attribute -> categoryAttributeWSBuilder.categoryAttributeEntityToWSBuilder(attribute))
				.collect(Collectors.toList());
		return saveddata;
	}
}
