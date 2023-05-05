package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRep;

	public String addEmployee(Employee emp) {
		empRep.save(emp);
		return "Successfully Saved";
	}

	public Employee getEmployee(int id) {

		return empRep.findById(id).get();

	}

	public String deleteEmployee(int id) {

		empRep.deleteById(id);
		return "delete successfully";

	}

	public String addEmployees(List<Employee> emp) {
		empRep.saveAll(emp);
		return "Successfully added";
	}

	public List<Employee> getEmployees() {

		return empRep.findAll();
	}

	public String updateEmployee(Employee id) {
		empRep.save(id);

		return "Successfully updated";
	}
	// QEURY QEURY QEURY QUERY

	public List<Employee> getBysal(int sal1, int sal2) {

		return empRep.getBySalary(sal1, sal2);
	}

}
