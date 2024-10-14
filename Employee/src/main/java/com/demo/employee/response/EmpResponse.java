package com.demo.employee.response;

import java.util.List;

import com.demo.employee.model.Employee;

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
public class EmpResponse {
	int code;
	String status;
	String message;
	List<Employee> data;
}
