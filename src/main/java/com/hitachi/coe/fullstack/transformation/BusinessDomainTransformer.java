package com.hitachi.coe.fullstack.transformation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.transformation.base.AbstractCopyPropertiesTransformer;
import com.hitachi.coe.fullstack.transformation.base.EntityToModelTransformer;

/**
 * The Class BusinessDomainTransformer is convert entity to DTO.
 * 
 * @author thovo
 *
 */
@Component
public class BusinessDomainTransformer extends AbstractCopyPropertiesTransformer<BusinessDomain, BusinessDomainModel>
		implements EntityToModelTransformer<BusinessDomain, BusinessDomainModel, Integer> {
		
		/**
		 * Transformer array entities to array DTO.
		 * 
		 * @param entities {@link List} of {@link BusinessDomain}
		 * @return {@link List} of {@link BusinessDomainModel}
		 */
		public List<BusinessDomainModel> applyList(List<BusinessDomain> entities) {
			if (null == entities || entities.isEmpty()) {
				return Collections.emptyList();
			}

			return entities.stream().map(this::apply)
					.collect(Collectors.toList());
		}
}
