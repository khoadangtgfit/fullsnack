package com.hitachi.coe.fullstack.repository;

import com.hitachi.coe.fullstack.entity.BusinessDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hitachi.coe.fullstack.entity.Practice;

import java.util.List;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Integer>{

	@Query(value = "SELECT p.* FROM practice p", nativeQuery = true)
	List<Practice> getPractices();
	@Override
	Practice save(Practice practice);
	
}
