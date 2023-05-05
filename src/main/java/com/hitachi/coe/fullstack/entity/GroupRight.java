package com.hitachi.coe.fullstack.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the group_right database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="group_right")
public class GroupRight extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	//bi-directional many-to-one association to GroupRight
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="group_id")
	private GroupRight groupRight;

	//bi-directional many-to-one association to GroupRight
	@OneToMany(mappedBy="groupRight", fetch = FetchType.LAZY)
	private List<GroupRight> groupRights;

	//bi-directional many-to-one association to Right
	@ManyToOne(fetch = FetchType.LAZY)
	private Right right;

}