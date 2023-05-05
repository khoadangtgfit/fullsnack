package com.hitachi.coe.fullstack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.repository.BusinessDomainRepository;
import com.hitachi.coe.fullstack.service.BusinessDomainService;
import com.hitachi.coe.fullstack.transformation.BusinessDomainTransformer;

@Service
@Transactional
public class BusinessDomainServiceImpl implements BusinessDomainService {

    @Autowired
    private BusinessDomainRepository businessDomainRepository;
    
    @Autowired
    BusinessDomainTransformer businessDomainTransformer;

	@Override
	public List<BusinessDomainModel> getBusinessDomains() {
		
		//convert entities to models
		return businessDomainTransformer.applyList(businessDomainRepository.getBusinessDomains());
	}
    
    

}
