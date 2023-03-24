package com.Ujjwal.springBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private Long departmentId;
	@NotBlank(message = "Please add  department name!")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
