package com.hitachi.coe.fullstack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.exceptions.ResourceNotFoundException;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.repository.BusinessDomainRepository;
import com.hitachi.coe.fullstack.repository.PracticeRepository;
import com.hitachi.coe.fullstack.service.BusinessDomainService;
import com.hitachi.coe.fullstack.transformation.BusinessDomainTransformer;

@Service
@Transactional
public class BusinessDomainServiceImpl implements BusinessDomainService {

    @Autowired
    private BusinessDomainRepository businessDomainRepository;
    
    @Autowired
    BusinessDomainTransformer businessDomainTransformer;
    
    @Autowired
    private PracticeRepository practiceRepository;

	@Override
	public List<BusinessDomainModel> getBusinessDomains() {
		
		//convert entities to models
		return businessDomainTransformer.applyList(businessDomainRepository.getBusinessDomains());
	}

	@Override
	public BusinessDomainModel addBusinessDomain(Integer practice_id,BusinessDomainModel businessDomainModel) {
		Practice practice=practiceRepository.findById(practice_id).orElseThrow(()->new ResourceNotFoundException("not found practice by id = "+practice_id));
		businessDomainModel.setPractice(practice);
		BusinessDomain businessDomain=businessDomainTransformer.applyModel(businessDomainModel);
		businessDomain = businessDomainRepository.save(businessDomain);
		BusinessDomainModel businessDomainModel1=new BusinessDomainModel();
		businessDomainModel1=businessDomainTransformer.apply(businessDomain);
		return businessDomainModel1;
	}
	
	
	

}
