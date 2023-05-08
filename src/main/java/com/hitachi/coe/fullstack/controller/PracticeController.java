package com.hitachi.coe.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.entity.Practice;
import com.hitachi.coe.fullstack.exceptions.ResourceNotFoundException;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.model.PracticeModel;
import com.hitachi.coe.fullstack.repository.PracticeRepository;
import com.hitachi.coe.fullstack.service.PracticeService;

@RestController
@RequestMapping("/api/v1/")
public class PracticeController {
	
	@Autowired
	PracticeService practiceService;
	
	@Autowired
	PracticeRepository practiceRepository;
	
//	@PostMapping("practices/{practice_id}/business_domains")
//	public ResponseEntity<BusinessDomainModel> addBusinessDomainToPractice(@PathVariable("practice_id") Integer practice_id, @RequestBody BusinessDomain businessDomain){
//		Practice practice=practiceRepository.findById(practice_id).orElseThrow(() -> new ResourceNotFoundException("Not found practice by id = "+practice_id));
//		BusinessDomainModel businessDomainModel=
//		return null;
//	}
}
