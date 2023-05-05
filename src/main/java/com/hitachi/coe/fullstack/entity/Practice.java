package com.hitachi.coe.fullstack.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the practice database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="practice")
public class Practice extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String code;

	private String description;

	private String manager;

	private String name;

	//bi-directional many-to-one association to BusinessDomain
	@OneToMany(mappedBy="practice", fetch = FetchType.LAZY)
	private List<BusinessDomain> businessDomains;

	//bi-directional many-to-one association to BusinessUnit
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="business_unit_id")
	private BusinessUnit businessUnit;

}