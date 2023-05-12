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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the project database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="project")
public class Project extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String code;

	@Column(name="customer_name")
	private String customerName;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private String name;

	@Column(name="project_manager")
	private String projectManager;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	private Integer status;

	//bi-directional many-to-one association to BusinessDomain
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="business_domain_id")
	@JsonIgnore
	private BusinessDomain businessDomain;

	//bi-directional many-to-one association to ProjectType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="project_type_id")
	@JsonIgnore
	private ProjectType projectType;

	//bi-directional many-to-one association to ProjectFeedback
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
	private List<ProjectFeedback> projectFeedbacks;

	//bi-directional many-to-one association to ProjectTech
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
	private List<ProjectTech> projectTeches;

}