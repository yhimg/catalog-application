package com.omnirio.catalogapplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.category.CategoryWS;

@RestController
@RequestMapping("/catalog")
public interface CatalogAPI {

	@GetMapping("/")
	String getStatus();

	@PostMapping("/category")
	ResponseEntity<Object> createCategory(@RequestBody @Valid CategoryWS categoryWS);

	@PostMapping("/category/{categoryId}/attributes")
	List<CategoryAttributeWS> createCategoryAttributesByCategoryId(@PathVariable @Valid Long categoryId, @RequestBody @Valid List<CategoryAttributeWS> categoryAttributeWS);

}
