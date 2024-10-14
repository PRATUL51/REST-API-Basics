package com.demo.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.employee.entity.EmployeeEntity;
import com.demo.employee.model.Employee;
import com.demo.employee.repository.EmployeeRepository;
import com.demo.employee.request.EmpRequest;
import com.demo.employee.response.EmpResponse;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public EmpResponse addEmployee(EmpRequest request) throws Exception {
		EmployeeEntity entity = new EmployeeEntity();

		if (viewEmplyessById(request.getEmployeeId()).getData().isEmpty()) {
			entity.setEmployeeId(request.getEmployeeId());
			entity.setEmployeeName(request.getEmployeeName());
			entity.setEmail(request.getEmail());
			entity.setDesignation(request.getDesignation());
			entity.setPhoneNo(request.getPhoneNo());
			entity.setLocation(request.getLocation());

			repo.save(entity);

			return new EmpResponse(HttpStatus.OK.value(), "SUCCESS",
					"Employee with Employee ID:" + request.getEmployeeId() + " added successfully!!", null);
		} else {

			return new EmpResponse(HttpStatus.BAD_REQUEST.value(), "FAILURE",
					"Employee with Employee ID:" + request.getEmployeeId() + " already exisit!!", null);

		}
	}

	@Override
	public EmpResponse viewEmployees() {
		List<EmployeeEntity> dataEntity;
		dataEntity = repo.findAll();

		List<Employee> model = dataEntity.stream().map(item -> new Employee(item.getEmployeeId(),
				item.getEmployeeName(), item.getEmail(), item.getPhoneNo(), item.getDesignation(), item.getLocation()))
				.collect(Collectors.toList());

		return new EmpResponse(HttpStatus.OK.value(), "SUCCESS", null, model);
	}

	@Override
	public EmpResponse viewEmplyessById(Long empId) {
		EmployeeEntity entity = repo.findById(empId).orElse(null);
		List<EmployeeEntity> dataEntity = new ArrayList<>();

		if (entity != null) {
			dataEntity.add(entity);
		} else {
			new ArrayList<>();
		}

		List<Employee> model = dataEntity.stream().map(item -> new Employee(item.getEmployeeId(),
				item.getEmployeeName(), item.getEmail(), item.getPhoneNo(), item.getDesignation(), item.getLocation()))
				.collect(Collectors.toList());

		return new EmpResponse(HttpStatus.OK.value(), "SUCCESS", null, model);
	}

	@Override
	public EmpResponse deleteEmployee(Long empId) {
		repo.deleteById(empId);

		return new EmpResponse(HttpStatus.OK.value(), "SUCCESS",
				"Employee with Employee ID:" + empId + " deleted successfully!!", null);
	}

	@Override
	public EmpResponse updateEmployee(EmpRequest request) {
		EmployeeEntity entity = repo.findById(request.getEmployeeId()).orElseThrow(() -> new RuntimeException(
				"Employee with Employee ID:" + request.getEmployeeId() + " does not exisit!!"));

		entity.setEmployeeId(request.getEmployeeId());
		entity.setEmployeeName(request.getEmployeeName());
		entity.setEmail(request.getEmail());
		entity.setDesignation(request.getDesignation());
		entity.setPhoneNo(request.getPhoneNo());
		entity.setLocation(request.getLocation());

		repo.save(entity);

		return new EmpResponse(HttpStatus.OK.value(), "SUCCESS",
				"Employee with Employee ID:" + request.getEmployeeId() + " updated successfully!!", null);
	}

	@Override
	public EmpResponse viewByDesignation(String designation) {
		List<EmployeeEntity> entity = repo.findByDesignation(designation);
		List<Employee> model = entity.stream().map(item -> new Employee(item.getEmployeeId(), item.getEmployeeName(),
				item.getEmail(), item.getPhoneNo(), item.getDesignation(), item.getLocation()))
				.collect(Collectors.toList());

		return new EmpResponse(HttpStatus.OK.value(), "SUCCESS", null, model);
	}

}
