package com.Ujjwal.springBootDemo.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import com.Ujjwal.springBootDemo.entity.Department;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findByDepartmentName(String departmentName);

	//if we want to give a sql query we can use @Query annotation as well
	//e.g. @Query(value="SQL_QUERY", nativeQuery = "true")// can give parameters as ?1 & ?2
	public Department findByDepartmentNameIgnoreCase(String departmentName);

}

