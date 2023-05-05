package com.hitachi.coe.fullstack.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hitachi.coe.fullstack.entity.base.BaseAudit;
import com.hitachi.coe.fullstack.entity.base.BaseReadonlyEntity;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the user database table.
 * 
 */
@Getter
@Setter
@Entity
@Table(name="user")
public class User extends BaseAudit implements BaseReadonlyEntity<Integer> {

	@Id
	private Integer id;

	private String email;

	private String name;
	
	//bi-directional many-to-one association to Group
	@ManyToOne(fetch = FetchType.LAZY)
	private Group group;

}