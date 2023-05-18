package com.hitachi.coe.fullstack.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the level database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="level")
public class Level extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String code;

	private String description;

	private String name;

	//bi-directional many-to-one association to EmployeeLevel
	@OneToMany(mappedBy="level", fetch = FetchType.LAZY)
	private List<EmployeeLevel> employeeLevels;

}