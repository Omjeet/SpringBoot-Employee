package com.example.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.dto.EmployeeDto;
import com.example.emp.entity.Employee;
import com.example.emp.repository.EmployeeRepository;
import com.example.emp.service.intf.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// post method
	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub

		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setMobileNo(employeeDto.getMobileNo());
		employee.setName(employeeDto.getName());

		employeeRepository.save(employee);

	}

	// get employee by id
	@Override
	public EmployeeDto getEmployeeDtoById(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.getOne(id);
		EmployeeDto employeeDto = employee.convertTODTO();
		return employeeDto;
	}

	// get list of employee

	@Override
	public List<EmployeeDto> employeeDtos() {
		// TODO Auto-generated method stub
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
		List<Employee> employees = employeeRepository.findAll();

		if (!employees.isEmpty()) {
			employees.forEach(i -> employeeDtos.add(i.convertTODTO()));
		}

		return employeeDtos;
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
		Employee employee = employeeRepository.getOne(employeeDto.getId());
		employee.setMobileNo(employeeDto.getMobileNo());
		employee.setName(employeeDto.getName());
		
		
		
		employeeRepository.save(employee);
	}

	

	/*@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setMobileNo(employeeDto.getMobileNo());
		employee.setName(employeeDto.getName());
		
		employeeRepository.save(employee);
		
	}*/
	

}
