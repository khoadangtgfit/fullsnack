package com.hitachi.coe.fullstack.service;


import java.util.List;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;

/**
 * This class is a service to CRUD data for business_domain table.
 * @author thovo
 *
 */
public interface BusinessDomainService {
    
    List<BusinessDomainModel> getBusinessDomains();
    BusinessDomainModel addBusinessDomain(Integer practice_id,BusinessDomainModel businessDomainModel);
}
