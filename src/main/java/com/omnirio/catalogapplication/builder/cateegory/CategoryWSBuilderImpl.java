package com.omnirio.catalogapplication.builder.cateegory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.ws.category.CategoryWS;

@Component
public class CategoryWSBuilderImpl implements CategoryWSBuilder{
	@Override
	public CategoryWS categoryEntityToWSBuilder(Category category) {
		return CategoryWS.builder()
				.id(category.getId())
				.categoryName(category.getCategoryName())
				.uuid(category.getUuid())
				.build();
	}

	@Override
	public Category categoryWSToEntityBuilder(CategoryWS categoryWS) {
		return Category.builder()
				.id(categoryWS.getId())
				.categoryName(categoryWS.getCategoryName())
				.uuid(UUID.randomUUID().toString())
				.build();
	}
}
