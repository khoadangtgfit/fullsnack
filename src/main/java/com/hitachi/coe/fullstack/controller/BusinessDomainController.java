package com.hitachi.coe.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(
        		businessDomainService.getBusinessDomains());
    }
}
