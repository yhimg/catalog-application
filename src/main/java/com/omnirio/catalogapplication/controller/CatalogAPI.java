package com.omnirio.catalogapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.category.CategoryWS;
import com.omnirio.catalogapplication.ws.product.ProductWS;

@RestController
@RequestMapping("/catalog")
public interface CatalogAPI {

	@GetMapping("/")
	String getStatus();

	@PostMapping("/category")
	ResponseEntity<Object> createCategory(@RequestBody @Valid CategoryWS categoryWS);

	@PostMapping("/category/{categoryId}/attributes")
	List<CategoryAttributeWS> createCategoryAttributesByCategoryId(@PathVariable @Valid Long categoryId, @RequestBody @Valid List<CategoryAttributeWS> categoryAttributeWS);

	@PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<ProductWS> createProduct(@RequestBody @Valid ProductWS productWS);

	@GetMapping("/product/{productId}")
	ResponseEntity<ProductWS> getProductById(@PathVariable @Valid Long productId);

	@GetMapping("/category/{categoryId}/attributes")
	List<CategoryAttributeWS> getCategoryAttributesByCategoryId(@PathVariable @Valid Long categoryId);

	@GetMapping("/category/{categoryId}")
	ResponseEntity<CategoryWS> getCategoryById(@PathVariable @Valid Long categoryId);

	@GetMapping("/product")
	ResponseEntity<List<ProductWS>> getAllProduct();
}
