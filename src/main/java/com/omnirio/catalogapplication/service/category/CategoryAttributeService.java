package com.omnirio.catalogapplication.service.category;

import java.util.List;

import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;

public interface CategoryAttributeService {
	List<CategoryAttributeWS> getCategoryAttributesByCategoryId(Long categoryId);

	List<CategoryAttributeWS>saveCategoryAttributes(Long categoryId, List<CategoryAttributeWS> categoryAttributeWS);
}
