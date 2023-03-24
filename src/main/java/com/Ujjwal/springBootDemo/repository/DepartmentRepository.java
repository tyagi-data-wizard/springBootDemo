package com.Ujjwal.springBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ujjwal.springBootDemo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findByDepartmentName(String departmentName);
	
	//if we want to give a sql query we can use @Query annotation as well
	//e.g. @Query(value="SQL_QUERY", nativeQuery = "true")// can give parameters as ?1 & ?2
	public Department findByDepartmentNameIgnoreCase(String departmentName);
}
