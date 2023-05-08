package com.hitachi.coe.fullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the employee_level database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="employee_level")
public class EmployeeLevel extends BaseAudit implements BaseReadonlyEntity<Integer> {
	
	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="level_date")
	private Date levelDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Employee employee;

	//bi-directional many-to-one association to Level
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Level level;

}