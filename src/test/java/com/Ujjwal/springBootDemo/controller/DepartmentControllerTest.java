package com.Ujjwal.springBootDemo.controller;

import com.Ujjwal.springBootDemo.entity.Department;
import com.Ujjwal.springBootDemo.error.DepartmentNotFoundException;
import com.Ujjwal.springBootDemo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(DepartmentController.class)             //since we want to test hitting end points, we'll use web mock mvc;
                                                    ///mock context will be created using this annotation
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockmvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setup(){

        department = department.builder().
                departmentAddress("Nainital").
                departmentCode("IT-06").
                departmentId(1L).
                departmentName("IT").
                build();



    }

    @Test
    void saveDepartment() throws Exception {

       Department inputDepartment = department.builder().
                departmentAddress("Nainital").
                departmentCode("IT-06").
                departmentName("IT").
                build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).
                thenReturn(department);

        mockmvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\":\"IT\",\n" +
                        "\t\"departmentAddress\":\"Nainital\",\n" +
                        "\t\"departmentCode\":\"IT-06\"\n" +
                        "}"))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        assertNotNull(department);
    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockmvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));

    }
}