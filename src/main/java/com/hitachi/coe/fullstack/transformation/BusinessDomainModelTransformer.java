package com.hitachi.coe.fullstack.transformation;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.transformation.base.AbstractCopyPropertiesTransformer;
import com.hitachi.coe.fullstack.transformation.base.EntityToModelTransformer;
import com.hitachi.coe.fullstack.transformation.base.ModelToEntityTransformer;
import org.springframework.stereotype.Component;

@Component
public class BusinessDomainModelTransformer extends AbstractCopyPropertiesTransformer<BusinessDomainModel, BusinessDomain>
        implements ModelToEntityTransformer<BusinessDomainModel, BusinessDomain, Integer> {
}
