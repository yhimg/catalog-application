package com.omnirio.catalogapplication.builder.product.attributes;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.omnirio.catalogapplication.model.product.Product;
import com.omnirio.catalogapplication.model.product.ProductAttributes;
import com.omnirio.catalogapplication.ws.product.ProductAttributeWS;

@Component
public class ProductAttributeWSBuilderImpl implements ProductAttributeWSBuilder{
	@Override
	public ProductAttributeWS productAttributeEntityToWSBuilder(ProductAttributes productAttributes) {
		return ProductAttributeWS.builder()
				.id(productAttributes.getId())
				.attributeName(productAttributes.getAttributeName())
				.attributeValue(productAttributes.getAttributeValue())
				.uuid(productAttributes.getUuid())
				.build();
	}

	@Override
	public ProductAttributes productAttributeWSToEntityBuilder(ProductAttributeWS productAttributeWS, Product product) {
		return ProductAttributes.builder()
				.id(productAttributeWS.getId())
				.product(product)
				.attributeName(productAttributeWS.getAttributeName())
				.attributeValue(productAttributeWS.getAttributeValue())
				.uuid(UUID.randomUUID().toString()).build();
	}
}
