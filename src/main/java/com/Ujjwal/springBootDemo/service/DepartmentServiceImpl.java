package com.Ujjwal.springBootDemo.service;

import java.util.List;
import java.util.Objects;

import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.Ujjwal.springBootDemo.entity.Department;
import com.Ujjwal.springBootDemo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		//using jpa inbuilt functionality to save our entity; jpa will make the table itself 
		return departmentRepository.save(department);			 
	}

	@Override
	public List<Department> fetchDepartmentList() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
	
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department oldDepartment = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) &&
				!"".equals(department.getDepartmentName())) {
			oldDepartment.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) &&
				!"".equals(department.getDepartmentCode())) {
			oldDepartment.setDepartmentCode(department.getDepartmentCode());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) &&
				!"".equals(department.getDepartmentAddress())) {
			oldDepartment.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return departmentRepository.save(oldDepartment);
	}

	
	
}
