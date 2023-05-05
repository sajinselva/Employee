package com.example.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(value = "select * from employee where salary >=? And salary <=?", nativeQuery = true)
	
	public List<Employee> getBySalary(int sal1, int sal2);
	
	
	

}
