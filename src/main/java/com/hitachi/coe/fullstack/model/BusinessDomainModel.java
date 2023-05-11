package com.hitachi.coe.fullstack.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.entity.Project;
import com.hitachi.coe.fullstack.model.base.AuditModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDomainModel extends AuditModel<Integer> {

    /**
	 * 
	 */
	private String code;

	private String description;

	private String name;

	private Practice practice;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Project> projects;

}
