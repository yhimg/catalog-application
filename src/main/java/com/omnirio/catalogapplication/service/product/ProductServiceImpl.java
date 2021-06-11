package com.omnirio.catalogapplication.service.product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.omnirio.catalogapplication.builder.cateegory.CategoryWSBuilder;
import com.omnirio.catalogapplication.builder.cateegory.attributes.CategoryAttributeWSBuilder;
import com.omnirio.catalogapplication.builder.product.ProductWSBuilder;
import com.omnirio.catalogapplication.builder.product.attributes.ProductAttributeWSBuilder;
import com.omnirio.catalogapplication.model.category.Category;
import com.omnirio.catalogapplication.model.category.CategoryAttributes;
import com.omnirio.catalogapplication.model.product.Product;
import com.omnirio.catalogapplication.model.product.ProductAttributes;
import com.omnirio.catalogapplication.repository.category.CategoryAttributesRepository;
import com.omnirio.catalogapplication.repository.category.CategoryRepository;
import com.omnirio.catalogapplication.repository.product.ProductAttributeRepository;
import com.omnirio.catalogapplication.repository.product.ProductRepository;
import com.omnirio.catalogapplication.ws.category.CategoryAttributeWS;
import com.omnirio.catalogapplication.ws.product.ProductAttributeWS;
import com.omnirio.catalogapplication.ws.product.ProductWS;

@Component
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductAttributeRepository productAttributeRepository;

	@Autowired
	private CategoryAttributesRepository categoryAttributesRepository;

	@Autowired
	private ProductWSBuilder productWSBuilder;

	@Autowired
	private ProductAttributeWSBuilder productAttributeWSBuilder;

	@Autowired
	private CategoryWSBuilder categoryWSBuilder;

	@Autowired
	private CategoryAttributeWSBuilder categoryAttributeWSBuilder;

	@Override
	@Transactional(readOnly = true)
	public Optional<ProductWS> getProductById(Long productId) {
		Optional<Product> product = productRepository.findById(productId);
		if(!product.isPresent())
			return Optional.empty();
		List<ProductAttributes> productAttributesList = productAttributeRepository.getAllByProductId(productId);
		List<ProductAttributeWS> productAttributeWSList = productAttributesList.parallelStream()
				.map(attribute -> productAttributeWSBuilder.productAttributeEntityToWSBuilder(attribute))
				.collect(Collectors.toList());

		Long categoryId = product.get().getCategory().getId();
		List<CategoryAttributes> categoryAttributesList = categoryAttributesRepository.findAllByCategoryId(categoryId);
		List<CategoryAttributeWS> categoryAttributeWSList = categoryAttributesList.parallelStream()
				.map(attribute -> categoryAttributeWSBuilder.categoryAttributeEntityToWSBuilder(attribute))
				.collect(Collectors.toList());

		Optional<ProductWS> productWS = Optional.of(productWSBuilder.productEntityToWSBuilder(product.get(), productAttributeWSList, categoryAttributeWSList));

		return productWS;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductWS> getAllProducts() {
		ProductWS productWS = ProductWS.builder().build();
		List<Product> savedProducts = productRepository.findAll();

		return null;
	}

	@Override
	@Transactional
	public ProductWS createProduct(ProductWS productWS) {
		Category category = categoryRepository.findById(productWS.getCategoryId()).get();

		List<CategoryAttributeWS> categoryAttributeWSList = category.getCategoryAttributes().stream()
				.map(attribute -> categoryAttributeWSBuilder.categoryAttributeEntityToWSBuilder(attribute))
				.collect(Collectors.toList());

		Product product = productWSBuilder.productWSToEntityBuilder(productWS, category);

		List<ProductAttributes> productAttributes = productWS.getProductAttributes().stream()
				.map(attribute -> productAttributeWSBuilder.productAttributeWSToEntityBuilder(attribute, product))
				.collect(Collectors.toList());

		product.setProductAttributes(productAttributes);

		Product savedProduct = productRepository.save(product);
		List<ProductAttributes> savedProductAttributes = productAttributeRepository.saveAll(productAttributes);
		savedProduct.setProductAttributes(savedProductAttributes);

		List<ProductAttributeWS> savedProductAttributesWS = savedProductAttributes.stream()
				.map(attribute -> productAttributeWSBuilder.productAttributeEntityToWSBuilder(attribute))
				.collect(Collectors.toList());

		ProductWS savedProductWS = productWSBuilder.productEntityToWSBuilder(savedProduct, savedProductAttributesWS, categoryAttributeWSList);

		return savedProductWS;
	}


}
