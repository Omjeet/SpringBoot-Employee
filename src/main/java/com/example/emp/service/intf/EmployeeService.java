package com.example.emp.service.intf;

import java.util.List;

import com.example.emp.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto getEmployeeDtoById(Integer id);

	public List<EmployeeDto> employeeDtos();

	public void addEmployee(EmployeeDto employeeDto);
	
	public void updateEmployee(EmployeeDto employeeDto);
	
	public EmployeeDto addProfile(EmployeeDto employeeDto);
	
	void deleteEmployee(Integer id);



}
