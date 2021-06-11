package com.omnirio.catalogapplication.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnirio.catalogapplication.model.product.ProductAttributes;

public interface ProductAttributeRepository extends JpaRepository<ProductAttributes, Long> {
	List<ProductAttributes> getAllByProductId(Long productId);
}
