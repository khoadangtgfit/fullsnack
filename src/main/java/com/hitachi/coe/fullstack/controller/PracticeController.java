package com.hitachi.coe.fullstack.controller;

import com.hitachi.coe.fullstack.model.PracticeModel;
import com.hitachi.coe.fullstack.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PracticeController {

	@Autowired
	private PracticeService practiceService;

	@GetMapping("practices")
	public ResponseEntity<List<PracticeModel>> getPractices(){
		return ResponseEntity.ok(practiceService.getPractices());
	}

	@PostMapping("practices")
	public ResponseEntity<PracticeModel> addPractice(){
		return re
	}

}
