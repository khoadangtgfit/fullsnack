package com.hitachi.coe.fullstack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.model.PracticeModel;
import com.hitachi.coe.fullstack.repository.PracticeRepository;
import com.hitachi.coe.fullstack.service.PracticeService;
import com.hitachi.coe.fullstack.transformation.PracticeTransformer;

@Service
@Transactional
public class PracticeServiceImpl implements PracticeService {

	@Autowired
	PracticeRepository practiceRepository;

	@Autowired
	PracticeTransformer practiceTransformer;

	@Override
	public PracticeModel addBusinessDomainToPratice(Practice practice) {
		return practiceTransformer.apply(practiceRepository.save(practice));
	}

}
