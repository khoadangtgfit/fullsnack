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
 * The persistent class for the right database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="right")
public class Right extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String code;

	private String module;

	//bi-directional many-to-one association to GroupRight
	@OneToMany(mappedBy="right", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<GroupRight> groupRights;
}