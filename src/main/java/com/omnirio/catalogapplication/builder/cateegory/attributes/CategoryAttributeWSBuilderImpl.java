package com.omnirio.catalogapplication.builder.cateegory.attributes;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.model.category.CategoryAttributes;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;

@Component
public class CategoryAttributeWSBuilderImpl implements CategoryAttributeWSBuilder{
	@Override
	public CategoryAttributeWS categoryAttributeEntityToWSBuilder(CategoryAttributes categoryAttributes) {
		return CategoryAttributeWS.builder()
				.id(categoryAttributes.getId())
				.uuid(categoryAttributes.getUuid())
				.attributeName(categoryAttributes.getAttributeName())
				.attributeValue(categoryAttributes.getAttributeValue())
				.build();
	}

	@Override
	public CategoryAttributes categoryAttributeWSToEntityBuilder(Category category, CategoryAttributeWS categoryAttributeWS) {
		return CategoryAttributes.builder()
				.id(categoryAttributeWS.getId())
				.uuid(UUID.randomUUID().toString())
				.attributeName(categoryAttributeWS.getAttributeName())
				.attributeValue(categoryAttributeWS.getAttributeValue())
				.category(category)
				.build();
	}
}
