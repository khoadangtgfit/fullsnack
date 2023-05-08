package com.hitachi.coe.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.service.BusinessDomainService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/")
public class BusinessDomainController {

	@Autowired
	private BusinessDomainService businessDomainService;

	@GetMapping("business-domain")
	@ApiOperation("This api will return list of Business Domains")
	public ResponseEntity<List<BusinessDomainModel>> getBusinessDomains() {
		// Get lot by date range
		return ResponseEntity.ok(businessDomainService.getBusinessDomains());
	}

	@PostMapping("practices/{practice_id}/business_domains")
	public ResponseEntity<BusinessDomainModel> addBusinessDomainToPractice(
			@PathVariable("practice_id") Integer practice_id, @RequestBody BusinessDomainModel businessDomainModel) {
		return ResponseEntity.ok(businessDomainService.addBusinessDomain(practice_id, businessDomainModel));
	}

}
