package com.hitachi.coe.fullstack.model;

import com.hitachi.coe.fullstack.entity.BusinessUnit;
import com.hitachi.coe.fullstack.model.base.AuditModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PracticeModel extends AuditModel<Integer>{

	private static final long serialVersionUID = 4741724320109840928L;
	
	private String code;

	private String description;
	
	private String manager;
	
	private BusinessUnit businessUnit;

	
}

