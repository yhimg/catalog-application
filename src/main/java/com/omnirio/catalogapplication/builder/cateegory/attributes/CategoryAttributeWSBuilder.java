package com.omnirio.catalogapplication.builder.cateegory.attributes;

import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.model.category.CategoryAttributes;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;

public interface CategoryAttributeWSBuilder {
	CategoryAttributeWS categoryAttributeEntityToWSBuilder(CategoryAttributes categoryAttributes);
	CategoryAttributes categoryAttributeWSToEntityBuilder(Category category, CategoryAttributeWS categoryAttributeWS);
}
