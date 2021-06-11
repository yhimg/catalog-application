package com.omnirio.catalogapplication.model.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicUpdate;

import com.omnirio.catalogapplication.model.product.Product;
import com.omnirio.catalogapplication.model.common.Auditable;

@Data
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category")
public class Category extends Auditable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uuid", nullable = false, unique = true)
	private String uuid;

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<CategoryAttributes> categoryAttributes = new ArrayList<>();

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Product> product = new ArrayList<>();



}
