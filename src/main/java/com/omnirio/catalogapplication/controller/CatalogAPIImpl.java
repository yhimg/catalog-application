package com.omnirio.catalogapplication.controller;

import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.omnirio.catalogapplication.service.category.CategoryAttributeService;
import com.omnirio.catalogapplication.service.category.CategoryService;
import com.omnirio.catalogapplication.service.product.ProductService;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.category.CategoryWS;

@Slf4j
@Component
public class CatalogAPIImpl implements CatalogAPI {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryAttributeService categoryAttributeService;

	@Override
	public String getStatus() {
		return "Catalog Application is UP and Running";
	}

	@Override
	public ResponseEntity<Object> createCategory(final CategoryWS categoryWS) {
		CategoryWS savedCategoryWS = categoryService.createCategory(categoryWS);
		if (Objects.isNull(savedCategoryWS))
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return ResponseEntity.ok(savedCategoryWS);
	}

	@Override
	public List<CategoryAttributeWS> createCategoryAttributesByCategoryId(Long categoryId, List<CategoryAttributeWS> categoryAttributeWS) {
		return categoryAttributeService.saveCategoryAttributes(categoryId, categoryAttributeWS);
	}
}
