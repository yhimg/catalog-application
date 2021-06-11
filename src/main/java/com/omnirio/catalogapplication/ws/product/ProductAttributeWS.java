package com.omnirio.catalogapplication.ws.product;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAttributeWS {
	private Long id;

	private Long productId;

	private String uuid;

	@NonNull
	private String attributeName;

	@NonNull
	private String attributeValue;
}
