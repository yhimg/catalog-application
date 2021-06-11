package com.omnirio.catalogapplication.ws.category;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryAttributeWS {

	private Long id;

	private Long categoryId;

	private String uuid;

	@NonNull
	private String attributeName;

	@NonNull
	private String attributeValue;

}
