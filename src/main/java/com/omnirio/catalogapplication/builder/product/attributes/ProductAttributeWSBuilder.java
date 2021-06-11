package com.omnirio.catalogapplication.builder.product.attributes;

import com.omnirio.catalogapplication.model.product.Product;
import com.omnirio.catalogapplication.model.product.ProductAttributes;
import com.omnirio.catalogapplication.ws.product.ProductAttributeWS;

public interface ProductAttributeWSBuilder {
	ProductAttributeWS productAttributeEntityToWSBuilder(ProductAttributes productAttributes);
	ProductAttributes productAttributeWSToEntityBuilder(ProductAttributeWS productAttributeWS, Product product);
}
