package com.hitachi.coe.fullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the survey_data database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="survey_data")
public class SurveyData implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private Integer agile;

	private String certificate;

	@Temporal(TemporalType.DATE)
	@Column(name="completion_time")
	private Date completionTime;

	@Column(name="current_address")
	private String currentAddress;

	private String email;

	@Column(name="employee_id")
	private String employeeId;

	private String english;

	@Column(name="full_name")
	private String fullName;

	private String japanese;

	private Integer manufacturing;

	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	@JsonIgnore
	private Date startTime;

	private Integer waterfall;

}