package com.omnirio.catalogapplication.service.category;

import java.util.Optional;

import com.omnirio.catalogapplication.ws.category.CategoryWS;

public interface CategoryService {
	CategoryWS createCategory(CategoryWS categoryWS);

	Optional<CategoryWS> getCategoryById(Long categoryId);

}
