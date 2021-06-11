package com.omnirio.catalogapplication.builder.product;

import java.util.List;

import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.model.product.Product;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.product.ProductAttributeWS;
import com.omnirio.catalogapplication.ws.product.ProductWS;

public interface ProductWSBuilder {
	ProductWS productEntityToWSBuilder(Product product, List<ProductAttributeWS> productAttributeWSList, List<CategoryAttributeWS> categoryAttributeWSList);
	Product productWSToEntityBuilder(ProductWS productWS, Category category);
}
