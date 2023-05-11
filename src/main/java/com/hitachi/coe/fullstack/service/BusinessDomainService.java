package com.hitachi.coe.fullstack.service;


import java.util.List;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import org.springframework.http.RequestEntity;

/**
 * This class is a service to CRUD data for business_domain table.
 * @author thovo
 *
 */
public interface BusinessDomainService {
    
    List<BusinessDomainModel> getBusinessDomains();
    BusinessDomainModel addBusinessDomain(Integer practice_id,BusinessDomainModel businessDomainModel);
    BusinessDomainModel getBusinessDomainById(Integer business_domain_id);
    BusinessDomainModel updateBusinessDomainById(Integer business_domain_id, BusinessDomainModel businessDomainModel);
    List<BusinessDomainModel> deleteBusinessDomainById(Integer business_domain_id);
}
