package com.hitachi.coe.fullstack.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the employee database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String email;

	@Column(name="hcc_id")
	private String hccId;

	private String ldap;

	@Temporal(TemporalType.DATE)
	@Column(name="legal_entity_hire_date")
	private Date legalEntityHireDate;

	@Column(name="location_id")
	private Integer locationId;

	private String name;

	//bi-directional many-to-one association to BusinessUnit
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="business_unit_id")
	@JsonIgnore
	private BusinessUnit businessUnit;

	//bi-directional many-to-one association to EmployeeEvaluation
	@OneToMany(mappedBy="employee1", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EmployeeEvaluation> employeeEvaluations1;

	//bi-directional many-to-one association to EmployeeEvaluation
	@OneToMany(mappedBy="employee2", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EmployeeEvaluation> employeeEvaluations2;

	//bi-directional many-to-one association to EmployeeLevel
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EmployeeLevel> employeeLevels;

	//bi-directional many-to-one association to EmployeeSkill
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EmployeeSkill> employeeSkills;

	//bi-directional many-to-one association to ProjectFeedback
	@OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProjectFeedback> projectFeedbacks;

}