package com.hitachi.coe.fullstack.service;

import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.model.PracticeModel;

import java.util.List;

/**
 * This class is a service to CRUD data for business_domain table.
 * @author khoa.dang1
 *
 */
public interface PracticeService {
	List<PracticeModel> getPractices();
	PracticeModel addBusinessDomainToPratice(Practice practice);
}
