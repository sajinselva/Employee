package com.example.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService emps;

	@PostMapping(value = "/add")
	public String addEmployee(@RequestBody Employee emp) {
		return emps.addEmployee(emp);
	}

	@GetMapping(value = "/getId/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return emps.getEmployee(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return emps.deleteEmployee(id);
	}

	@PostMapping(value = "/listAdd")
	public String addEmployees(@RequestBody List<Employee> emp) {
		return emps.addEmployees(emp);

	}

	@GetMapping(value = "/getList")
	public List<Employee> getEmployees() {
		return emps.getEmployees();
	}

	@PutMapping(value = "/update/{id}")
	public String updateEmployee(@RequestBody Employee id) {
		return emps.updateEmployee(id);
	}

	@GetMapping(value = "/getEmpGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return emps.getByGender(gender);
	}

	@GetMapping(value = "/getNames/{male}")
	public List<String> getNames(@PathVariable String male) {
		return emps.getNames(male);
	}

	@GetMapping(value = "/highSal/{sal}")
	public List<String> getMaxSal(@PathVariable int sal) {
		return emps.getMaxSal(sal);
	}

	@GetMapping(value = "/maxSal")
	public String getMaxSal() {
		return emps.getHighSal();
	}

	@GetMapping(value = "/minAge")
	public Employee minimumAge() {
		return emps.minimumAge();
	}

	@GetMapping(value = "/ages/{age1}/{age2}")
	public List<String> betweenNames(@PathVariable int age1, @PathVariable int age2) {
		return emps.betweenNames(age1, age2);

	}

	@GetMapping(value = "/salary/{n1}/{n2}")
	public List<Integer> SalaryBetween(@PathVariable int n1, @PathVariable int n2) {
		return emps.SalaryBetween(n1, n2);

	}

	@GetMapping(value = "/nameID/{name}")
	public List<Integer> nameToId(@PathVariable String name) {
		return emps.nameToId(name);
	}

	@GetMapping(value = "increment")
	public List<Employee> increment() {
		return emps.increment();
	}
	
	//QUERY TOPIC
	
	@GetMapping(value = "/getBySal/{sal1}/{sal2}")
	
	public List<Employee> getBySal(@PathVariable int sal1, @PathVariable int sal2){
		return emps.getBysal(sal1, sal2);
	}
}
