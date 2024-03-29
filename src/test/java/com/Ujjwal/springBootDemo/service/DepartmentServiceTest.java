package com.Ujjwal.springBootDemo.service;

import com.Ujjwal.springBootDemo.entity.Department;
import com.Ujjwal.springBootDemo.error.DepartmentNotFoundException;
import com.Ujjwal.springBootDemo.repository.DepartmentRepository;
import lombok.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    //BeforeEach - this method will be called before each test function is called to set up some things
    //BeforeAll - this method will be called only once before all the test functions are called to set up some things
    @BeforeEach
    void setUp() {

        //here we are creating the object of department and instead of using constructors
        // and giving all the parameters manually we will use the lombok feature "builder" for this
        Department department =
                        Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Bangalore")
                        .departmentCode("IT-07")
                        .departmentId(1L)
                        .build();

        Optional<Department> departmentOptional = Optional.ofNullable(department);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);


        //when calling fetchDepartmentByName it will call findByDepartmentNameIgnoreCase;
        // and then our code will return this object that we created in setUp()
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

       Mockito.when(departmentRepository.findById(1L)).thenReturn(departmentOptional);

        Mockito.when(departmentRepository.findAll()).thenReturn(departmentList);

    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")     // we can use this annotation to change display name for better understanding
    // we can use @Disabled for disabling any particular test cases/methods
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        // we just want to test the service layer, and not call the actual code after it
        // which would be called after calling method
        // we will just mock the data/layer
        // ( in this case it is calling departmentRepository.findByDepartmentNameIgnoreCase(departmentName);)
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }


    @Test
    @DisplayName("Fetch all Departments")
    public void fetchDepartmentListTest(){
        List<Department> departmentList = departmentService.fetchDepartmentList();

        assertNotNull(departmentList);

    }

    @Test
    @DisplayName("Get data based on valid department id")
    public void whenValidDepartmentId_thenDepartmentShouldFound() throws DepartmentNotFoundException {
        Long departmentId = 1L;


        Department found = departmentService.fetchDepartmentById(departmentId);
     //assertDoesNotThrow(DepartmentNotFoundException);
        assertEquals(departmentId,found.getDepartmentId());
    }


}