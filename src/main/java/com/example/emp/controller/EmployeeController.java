package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.dto.EmployeeDto;
import com.example.emp.service.intf.EmployeeService;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/add")
	public void addemployee(@RequestBody EmployeeDto employeeDto) {

		employeeService.addEmployee(employeeDto);

	}

	@GetMapping(path = "/all")
	public List<EmployeeDto> employeeDtos() {
		return employeeService.employeeDtos();

	}

	@GetMapping(path = "/{id}")
	public EmployeeDto getEmployeeDtoById(@PathVariable(name = "id") Integer id) {

		return employeeService.getEmployeeDtoById(id);

	}

	@PutMapping(path = "/update")
	public void updateEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.updateEmployee(employeeDto);
	}

//	@PutMapping(path = "/addprofile")
//	public void addProfile(EmployeeDto employeeDto) {
//
//		employeeService.addEmployee(employeeDto);
//	}

	@DeleteMapping(path = "/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}

}
