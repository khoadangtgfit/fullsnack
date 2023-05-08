package com.hitachi.coe.fullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hitachi.coe.fullstack.entity.BusinessDomain;

/**
 * The Interface BusinessDomainRepository is using to access BusinessDomain table.
 */
@Repository
public interface BusinessDomainRepository extends JpaRepository<BusinessDomain, Integer> {

    @Query(value = "SELECT bd.* FROM business_domain bd", nativeQuery = true)
    List<BusinessDomain> getBusinessDomains();
    
//    @Override
//    BusinessDomain save(BusinessDomain businessDomain);
}

