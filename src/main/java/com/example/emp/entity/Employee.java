package com.example.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.emp.dto.EmployeeDto;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id")
	@SequenceGenerator(name = "emp_id", initialValue =1, allocationSize =1,sequenceName = "empid_seq")
	@Column
	private Integer id;

	@Column
	private String name;

	@Column
	private Long mobileNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public EmployeeDto convertTODTO() {

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(this.getId());
		employeeDto.setMobileNo(this.getMobileNo());
		employeeDto.setName(this.getName());

		return employeeDto;
	}

}
