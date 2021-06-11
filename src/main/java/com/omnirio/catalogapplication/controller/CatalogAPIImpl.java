package com.omnirio.catalogapplication.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
import com.omnirio.catalogapplication.ws.product.ProductWS;

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

	@Override
	public ResponseEntity<ProductWS> createProduct(ProductWS productWS) {
		ProductWS savedProductWS = productService.createProduct(productWS);
		return ResponseEntity.ok(savedProductWS);
	}

	@Override
	public ResponseEntity<ProductWS> getProductById(Long productId) {
		Optional<ProductWS> productWS = productService.getProductById(productId);
		if (!productWS.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).header("count", "0").build();
		return ResponseEntity.ok(productWS.get());
	}

	@Override
	public List<CategoryAttributeWS> getCategoryAttributesByCategoryId(Long categoryId) {
		return categoryAttributeService.getCategoryAttributesByCategoryId(categoryId);
	}

	@Override
	public ResponseEntity<CategoryWS> getCategoryById(Long categoryId) {
		Optional<CategoryWS> savedCategoryWS = categoryService.getCategoryById(categoryId);
		if (!savedCategoryWS.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(savedCategoryWS.get());
	}

	@Override
	public ResponseEntity<List<ProductWS>> getAllProduct() {
		return null;
	}


}
