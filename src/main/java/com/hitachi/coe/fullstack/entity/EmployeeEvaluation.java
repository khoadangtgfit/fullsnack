package com.hitachi.coe.fullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * The persistent class for the employee_evaluation database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="employee_evaluation")
public class EmployeeEvaluation extends BaseAudit implements BaseReadonlyEntity<Integer> {
	
	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="evaluation_date")
	private Date evaluationDate;

	@Column(name="evaluation_info")
	private String evaluationInfo;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="evaluator_id")
	@JsonIgnore
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id")
	@JsonIgnore
	private Employee employee2;
}