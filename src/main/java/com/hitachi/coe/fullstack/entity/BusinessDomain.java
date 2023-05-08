package com.hitachi.coe.fullstack.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * The persistent class for the business_domain database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="business_domain")
public class BusinessDomain extends BaseAudit implements BaseReadonlyEntity<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to Practice
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Practice practice;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="businessDomain", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Project> projects;

}