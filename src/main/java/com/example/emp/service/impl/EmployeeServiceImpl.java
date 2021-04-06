package com.example.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.dto.EmployeeDto;
import com.example.emp.entity.Designation;
import com.example.emp.entity.Employee;
import com.example.emp.repository.DesignationRepository;
import com.example.emp.repository.EmployeeRepository;
import com.example.emp.service.intf.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DesignationRepository designationRepository;

	// post method
	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub

		Employee employee = new Employee();

		employee.setMobileNo(employeeDto.getMobileNo());
		employee.setName(employeeDto.getName());

		int designationId = employeeDto.getDesignationDto().getId();
		Designation designation = designationRepository.getOne(designationId);
		employee.setDesignation(designation);

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
			for (Employee employee : employees) {
				employeeDtos.add(employee.convertTODTO());
			}
		}

//		
//		if (!employees.isEmpty()) {
//			employees.forEach(i -> employeeDtos.add(i.convertTODTO()));
//		}

		return employeeDtos;
	}

	@Override
	// for update employee
	public void updateEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub

		Employee employee = employeeRepository.getOne(employeeDto.getId());
		employee.setMobileNo(employeeDto.getMobileNo());
		employee.setName(employeeDto.getName());

		int designationId = employeeDto.getDesignationDto().getId();

		Designation designation = designationRepository.getOne(designationId);
		employee.setDesignation(designation);

		employeeRepository.save(employee);
	}

	@Override
	public EmployeeDto addProfile(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
//
//		Employee employee = employeeRepository.getOne(employeeDto.getId());
//
//		Designation designation = designationRepository.getOne(employeeDto.getDesignationDto().getId());
//		employee.setDesignation(designation);
//
//		employeeRepository.save(employee);
//		return employee.convertTODTO();
		return employeeDto;

	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.getOne(id);
		employeeRepository.delete(employee);
		
	}



}
