package com.demo.employee.service;

import org.springframework.stereotype.Service;

import com.demo.employee.request.EmpRequest;
import com.demo.employee.response.EmpResponse;

@Service
public interface EmpService {
	public EmpResponse addEmployee(EmpRequest request) throws Exception;
	
	public EmpResponse viewEmployees();
	
	public EmpResponse viewEmplyessById(Long empId);
	
	public EmpResponse deleteEmployee(Long empId);
	
	public EmpResponse updateEmployee(EmpRequest request);
	
	public EmpResponse viewByDesignation(String designation);
}
