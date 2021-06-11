package com.omnirio.catalogapplication.service.product;

import java.util.List;
import java.util.Optional;

import com.omnirio.catalogapplication.ws.product.ProductWS;

public interface ProductService {

	Optional<ProductWS> getProductById(Long productId);

	List<ProductWS> getAllProducts();

	ProductWS createProduct(ProductWS productWS);

}
