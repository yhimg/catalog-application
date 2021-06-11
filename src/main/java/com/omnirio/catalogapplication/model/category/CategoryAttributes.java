package com.omnirio.catalogapplication.model.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicUpdate;

import com.omnirio.catalogapplication.model.common.Auditable;

@Data
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "category_attributes")
public class CategoryAttributes extends Auditable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@Column(name = "uuid", nullable = false, unique = true)
	private String uuid;

	@Column(name = "attribute_name", nullable = false)
	private String attributeName;

	@Column(name = "attribute_value", nullable = false)
	private String attributeValue;
}
