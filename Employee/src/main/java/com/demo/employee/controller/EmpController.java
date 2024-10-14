package com.demo.employee.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.employee.request.EmpRequest;
import com.demo.employee.response.EmpResponse;
import com.demo.employee.service.EmpService;

@Controller
@CrossOrigin
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	EmpService service;

	@PostMapping("/add")
	public ResponseEntity<EmpResponse> addEmp(@RequestBody EmpRequest req) throws Exception {
		return ResponseEntity.ok(service.addEmployee(req));
	}
	
	@GetMapping("/view")
	public ResponseEntity<EmpResponse> viewEmp() throws Exception {
		return ResponseEntity.ok(service.viewEmployees());
	}
	
	@GetMapping("/view/{empId}")
	public ResponseEntity<EmpResponse> viewEmpById(@RequestParam Long empId) {
		return ResponseEntity.ok(service.viewEmplyessById(empId));
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<EmpResponse> deleteEmp(@RequestParam Long empId) {
		return ResponseEntity.ok(service.deleteEmployee(empId));
	}
	
	@PutMapping("/modify")
	public ResponseEntity<EmpResponse> updateEmp(@RequestBody EmpRequest req){
		return ResponseEntity.ok(service.updateEmployee(req));
	}
	
	@GetMapping("/viewBy/{designation}")
	public ResponseEntity<EmpResponse> viewEmpByDesignation(@RequestParam String designation) {
		return ResponseEntity.ok(service.viewByDesignation(designation));
	}

}
