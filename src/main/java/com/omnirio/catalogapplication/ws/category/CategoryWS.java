package com.omnirio.catalogapplication.ws.category;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryWS {

	private Long id;

	private String uuid;

	@NonNull
	private String categoryName;

}
