package com.hitachi.coe.fullstack.service.impl;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.exceptions.ResourceNotFoundException;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.repository.BusinessDomainRepository;
import com.hitachi.coe.fullstack.repository.PracticeRepository;
import com.hitachi.coe.fullstack.service.BusinessDomainService;
import com.hitachi.coe.fullstack.transformation.BusinessDomainTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BusinessDomainServiceImpl implements BusinessDomainService {

    @Autowired
    private BusinessDomainRepository businessDomainRepository;

    @Autowired
    private BusinessDomainService businessDomainService;

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
    public BusinessDomainModel addBusinessDomain(Integer practice_id, BusinessDomainModel businessDomainModel) {
        Practice practice = practiceRepository.findById(practice_id).orElseThrow(() -> new ResourceNotFoundException("not found practice by id = " + practice_id));
        businessDomainModel.setPractice(practice);
        BusinessDomain businessDomain = businessDomainTransformer.applyModel(businessDomainModel);
        businessDomain = businessDomainRepository.save(businessDomain);
        BusinessDomainModel businessDomainModel1 = new BusinessDomainModel();
        businessDomainModel1 = businessDomainTransformer.apply(businessDomain);
        return businessDomainModel1;
    }

    @Override
    public BusinessDomainModel getBusinessDomainById(Integer business_domain_id) {
        BusinessDomain businessDomain = businessDomainRepository.findById(business_domain_id).orElseThrow(() -> new ResourceNotFoundException("not found businessdomain by id = " + business_domain_id));
        BusinessDomainModel businessDomainModel = new BusinessDomainModel();
        businessDomainModel = businessDomainTransformer.apply(businessDomain);
        return businessDomainModel;
    }

    @Override
    public BusinessDomainModel updateBusinessDomainById(Integer business_domain_id, BusinessDomainModel businessDomainModel) {
        BusinessDomain businessDomainData = businessDomainRepository.findById(business_domain_id).orElseThrow(() -> new ResourceNotFoundException("not found businessdomain by id " + business_domain_id));
        BusinessDomain businessDomain = businessDomainTransformer.applyModel(businessDomainModel);
        businessDomain.setPractice(businessDomainData.getPractice());
        businessDomain.setId(business_domain_id);
        businessDomain.setCreated(businessDomainData.getCreated());
        businessDomain.setUpdated(new Date());
        BusinessDomain bd = businessDomainRepository.save(businessDomain);
        BusinessDomainModel businessDomainModelDTO = businessDomainTransformer.apply(bd);
        return businessDomainModelDTO;
    }

    @Override
    public List<BusinessDomainModel> deleteBusinessDomainById(Integer business_domain_id) {
        BusinessDomain businessDomainData = businessDomainRepository.findById(business_domain_id).orElseThrow(() -> new ResourceNotFoundException("not found businessdomain by id " + business_domain_id));
        businessDomainRepository.deleteById(business_domain_id);
        return businessDomainService.getBusinessDomains();
    }


}
