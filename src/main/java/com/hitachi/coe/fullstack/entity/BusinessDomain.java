package com.hitachi.coe.fullstack.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the business_domain database table.
 * 
 */
@Entity
@Getter
@Setter
@Table(name="business_domain")
@NamedQuery(name="BusinessDomain.findAll", query="SELECT b FROM BusinessDomain b")
public class BusinessDomain extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to Practice
	@ManyToOne
	@JsonIgnore
	private Practice practice;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="businessDomain")
	private List<Project> projects;

}