package com.hitachi.coe.fullstack.transformation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.model.PracticeModel;
import com.hitachi.coe.fullstack.transformation.base.AbstractCopyPropertiesTransformer;
import com.hitachi.coe.fullstack.transformation.base.EntityToModelTransformer;

@Component
public class PracticeTransformer extends AbstractCopyPropertiesTransformer<Practice, PracticeModel>
		implements EntityToModelTransformer<Practice, PracticeModel, Integer> {

	
	/**
	 * Transformer array entities to array DTO.
	 * 
	 * @param entities {@link List} of {@link Practice}
	 * @return {@link List} of {@link PracticeModel}
	 */
	public List<PracticeModel> applyList(List<Practice> entities) {
		if (null == entities || entities.isEmpty()) {
			return Collections.emptyList();
		}

		return entities.stream().map(this::apply)
				.collect(Collectors.toList());
	}
	
	 /**
     * Transforms a {@link BusinessDomain} entity to a {@link BusinessDomainModel} DTO.
     *
     * @param entity the {@link BusinessDomain} entity
     * @return the {@link BusinessDomainModel} DTO
     */
	
	public PracticeModel apply(Practice entity) {
		if(entity==null) {
			return null;
		}
		PracticeModel model=new PracticeModel();
		BeanUtils.copyProperties(entity, model);
		return model;
	}
}
