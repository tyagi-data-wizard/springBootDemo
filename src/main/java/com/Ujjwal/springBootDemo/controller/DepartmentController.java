package com.Ujjwal.springBootDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ujjwal.springBootDemo.entity.Department;
import com.Ujjwal.springBootDemo.service.DepartmentService;
import com.Ujjwal.springBootDemo.service.DepartmentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		// we dont want to create object manually so we will define so we use @Autowired
		//DepartmentService service = new DepartmentServiceImpl();			
		logger.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		logger.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("Inside fetchDepartmentById of DepartmentController");
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("Inside deleteDepartmentById of DepartmentController");
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted Successfullyy!";
		
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department) {
		logger.info("Inside updateDepartment of DepartmentController");
		return departmentService.updateDepartment(departmentId,department);
		
	}

	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
		logger.info("Inside fetchDepartmentByName of DepartmentController");
		return departmentService.fetchDepartmentByName(departmentName);
	}
	

}
