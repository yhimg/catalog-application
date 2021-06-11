package com.omnirio.catalogapplication.model.common;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
	@CreationTimestamp
	@Column(name = "created_on", updatable = false)
	protected LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "last_modified")
	protected LocalDateTime lastModifiedDate;
}
