package com.demo.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.employee.entity.EmployeeEntity;


import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
						
	@Query(" SELECT e FROM Employee e WHERE e.designation = :designation ")
	public List<EmployeeEntity> findByDesignation(@Param("designation") String designation);
}
