package com.demo.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
	private Long employeeId;
	private String employeeName;
	private String email;
	private Long phoneNo;
	private String designation;
	private String location;
}
