package com.omnirio.catalogapplication.builder.product;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.model.product.Product;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.product.ProductAttributeWS;
import com.omnirio.catalogapplication.ws.product.ProductWS;

@Component
public class ProductWSBuilderImpl implements ProductWSBuilder{
	@Override
	public ProductWS productEntityToWSBuilder(Product product, List<ProductAttributeWS> productAttributeWSList, List<CategoryAttributeWS> categoryAttributeWSList) {
		return ProductWS.builder()
				.productId(product.getId())
				.productName(product.getProductName())
				.categoryId(product.getCategory().getId())
				.productAttributes(productAttributeWSList)
				.categoryAttributes(categoryAttributeWSList)
				.build();
	}

	@Override
	public Product productWSToEntityBuilder(ProductWS productWS, Category category) {
		return Product.builder()
				.id(productWS.getProductId())
				.productName(productWS.getProductName())
				.category(category)
				.uuid(UUID.randomUUID().toString())
				.build();
	}
}
