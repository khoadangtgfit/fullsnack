package com.hitachi.coe.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitachi.coe.fullstack.entity.Practice;
@Repository
public interface PracticeRepository extends JpaRepository<Practice, Integer>{
	
	@Override
	Practice save(Practice practice);
	
}
