package com.demo.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Employee")
@Table(name = "Employee")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEntity {
	@Id
	@Column(name = "emp_id")
	private Long employeeId;

	@Column(name = "emp_name")
	private String employeeName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_no")
	private Long phoneNo;

	@Column(name = "designation")
	private String designation;

	@Column(name = "location")
	private String location;
}
