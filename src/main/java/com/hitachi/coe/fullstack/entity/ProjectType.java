package com.hitachi.coe.fullstack.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the project_type database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="project_type")
public class ProjectType extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String code;

	private String name;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectType", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Project> projects;

}