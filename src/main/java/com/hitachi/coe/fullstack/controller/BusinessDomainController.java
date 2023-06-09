package com.hitachi.coe.fullstack.controller;

import com.hitachi.coe.fullstack.model.BusinessDomainModel;
import com.hitachi.coe.fullstack.service.BusinessDomainService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BusinessDomainController {

    @Autowired
    private BusinessDomainService businessDomainService;

    @GetMapping("business-domains")
    @ApiOperation("This api will return list of Business Domains")
    public ResponseEntity<List<BusinessDomainModel>> getBusinessDomains() {
        // Get lot by date range
        List<BusinessDomainModel> listModel = new ArrayList<>();
        listModel =businessDomainService.getBusinessDomains();
        return ResponseEntity.ok(listModel);
    }

    @GetMapping("business-domains/{business-domains_id}")
    @ApiOperation("This api will return a Business Domains by id")
    public ResponseEntity<BusinessDomainModel> getBusinessDomainById(@PathVariable("business-domains_id") Integer business_domains_id) {
        return ResponseEntity.ok(businessDomainService.getBusinessDomainById(business_domains_id));
    }

    @PutMapping("business-domains/{business-domains_id}")
    @ApiOperation("This api will update a Business Domains by id")
    public ResponseEntity<BusinessDomainModel> updateBusinessDomainById(@PathVariable("business-domains_id") Integer business_domains_id, @RequestBody BusinessDomainModel businessDomainModel) {
        return ResponseEntity.ok(businessDomainService.updateBusinessDomainById(business_domains_id, businessDomainModel));
    }

    @PostMapping("practices/{practice_id}/business_domains")
    @ApiOperation("This api will add a Business Domains to a practice")
    public ResponseEntity<BusinessDomainModel> addBusinessDomainToPractice(
            @PathVariable("practice_id") Integer practice_id, @RequestBody BusinessDomainModel businessDomainModel) {
        return ResponseEntity.ok(businessDomainService.addBusinessDomain(practice_id, businessDomainModel));
    }

    @DeleteMapping("business-domains/{business-domains_id}")
    @ApiOperation("This api will delete a Business Domains from database")
    public ResponseEntity<List<BusinessDomainModel>> deleteBusinessDomainById(@PathVariable("business-domains_id") Integer business_domains_id){
        return ResponseEntity.ok(businessDomainService.deleteBusinessDomainById(business_domains_id));
    }

}
