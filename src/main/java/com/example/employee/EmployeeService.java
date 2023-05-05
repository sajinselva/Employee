package com.example.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdeo;

	public String addEmployee(Employee emp) {
		return empdeo.addEmployee(emp);
	}

	public Employee getEmployee(int id) {

		return empdeo.getEmployee(id);
	}

	public String deleteEmployee(int id) {

		return empdeo.deleteEmployee(id);
	}

	public String addEmployees(List<Employee> emp) {

		return empdeo.addEmployees(emp);
	}

	public List<Employee> getEmployees() {

		return empdeo.getEmployees();
	}

	public String updateEmployee(Employee id) {

		return empdeo.updateEmployee(id);
	}

	public List<Employee> getByGender(String gender) {

		return empdeo.getEmployees().stream().filter(x -> x.getGender().equalsIgnoreCase(gender))
				.collect(Collectors.toList());
	}

	public List<String> getNames(String male) {

		return empdeo.getEmployees().stream().filter(x -> x.getGender().equals(male)).map(y -> y.getName())
				.collect(Collectors.toList());
	}

	public List<String> getMaxSal(int sal) {

		return empdeo.getEmployees().stream().filter(x -> x.getSalary() > sal).map(y -> y.getName())
				.collect(Collectors.toList());
	}

	public String getHighSal() {
		List<Employee> all = empdeo.getEmployees();
		String a = null;
		int temp = all.get(0).getAge();
		for (Employee x : all) {
			if (x.getAge() >= temp) {
				a = x.getName();
			}

		}
		return a;
	}

	public Employee minimumAge() {
		List<Employee> all = empdeo.getEmployees();
		int min = all.get(0).getSalary();
		Employee em = null;
		for (Employee x : all) {
			if (x.getSalary() <= min) {
				min = x.getSalary();
				em = x;
			}
		}
		return em;

	}

	public List<String> betweenNames(int age1, int age2) {
		List<Employee> all = empdeo.getEmployees();

		return all.stream().filter(x -> x.getAge() > age1 && x.getAge() < age2).map(y -> y.getName())
				.collect(Collectors.toList());
	}

	public List<Integer> SalaryBetween(int n1, int n2) {
		List<Employee> all = empdeo.getEmployees();

		return all.stream().filter(x -> x.getSalary() > n1 && x.getSalary() < n2).map(y -> y.getId())
				.collect(Collectors.toList());

	}

	public List<Integer> nameToId(String name) {
		List<Employee> all = empdeo.getEmployees();
		return all.stream().filter(x -> x.getName().equalsIgnoreCase(name)).map(y -> y.getId())
				.collect(Collectors.toList());
	}

	public List<Employee> increment() {
		List<Employee> all = empdeo.getEmployees();

		for (Employee x : all) {
			if (x.getAge() > 25) {
				x.setSalary(x.getSalary() + (x.getSalary() / 100 * 5));

			}

		}
		return all;
	}

	// QUERY QUERY QUERY

	public List<Employee> getBysal(int sal1, int sal2) {

		return empdeo.getBysal(sal1, sal2);
	}

}
