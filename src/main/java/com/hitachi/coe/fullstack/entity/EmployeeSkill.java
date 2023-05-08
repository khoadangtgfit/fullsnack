package com.hitachi.coe.fullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the employee_skill database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="employee_skill")
@NamedQuery(name="EmployeeSkill.findAll", query="SELECT e FROM EmployeeSkill e")
public class EmployeeSkill extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	@Column(name="skill_level")
	private Integer skillLevel;

	@Temporal(TemporalType.DATE)
	@Column(name="skill_set_date")
	private Date skillSetDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Employee employee;

	//bi-directional many-to-one association to SkillSet
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="skill_set_id")
	@JsonIgnore
	private SkillSet skillSet;
}