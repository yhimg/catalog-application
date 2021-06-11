package com.omnirio.catalogapplication.ws.product;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;

@Data
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductWS {

	private Long productId;

	@NonNull
	private String productName;
	private List<ProductAttributeWS> productAttributes = new ArrayList<>();

	@NonNull
	private Long categoryId;
	private List<CategoryAttributeWS> categoryAttributes = new ArrayList<>();


}
