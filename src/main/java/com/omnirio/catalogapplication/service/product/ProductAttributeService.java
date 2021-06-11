package com.omnirio.catalogapplication.service.product;

import java.util.List;

import com.omnirio.catalogapplication.model.product.ProductAttributes;

public interface ProductAttributeService {
	List<ProductAttributes> createProductAttributes(List<ProductAttributes> productAttributes);
}
