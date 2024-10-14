package com.demo.employee.request;

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
public class EmpRequest {
	private Long employeeId;
	private String employeeName;
	private String email;
	private Long phoneNo;
	private String designation;
	private String location;
}
