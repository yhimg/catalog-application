package com.omnirio.catalogapplication.builder.cateegory;

import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.ws.category.CategoryWS;

public interface CategoryWSBuilder {
	CategoryWS categoryEntityToWSBuilder(Category category);

	Category categoryWSToEntityBuilder(CategoryWS categoryWS);
}
