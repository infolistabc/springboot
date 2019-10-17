package com.sun.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;

	private String method;

	private String path;

	private Integer status;

	private String username;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date modifyTime;

}
