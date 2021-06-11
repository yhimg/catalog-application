package com.omnirio.catalogapplication.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.omnirio.catalogapplication.model.product.ProductAttributes;
import com.omnirio.catalogapplication.repository.product.ProductAttributeRepository;

@Component
public class ProductAttributeServiceImpl implements ProductAttributeService{

	@Autowired
	private ProductAttributeRepository productAttributeRepository;

	@Override
	@Transactional
	public List<ProductAttributes> createProductAttributes(List<ProductAttributes> productAttributes) {
		return productAttributeRepository.saveAll(productAttributes);
	}
}
