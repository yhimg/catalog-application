package com.omnirio.catalogapplication.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.catalogapplication.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
