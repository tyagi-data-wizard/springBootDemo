package com.Ujjwal.springBootDemo.repository;

import com.Ujjwal.springBootDemo.entity.Department;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


//for testing repository we can use in memory db or containerized databases
@Data
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical")
                .departmentCode("ME-011")
                .departmentAddress("Delhi")
                .build();

        //this data will persist before we call our test method/case
        entityManager.persist(department);
    }
    @Test
    public void whenFindById_theReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical");





    }
}