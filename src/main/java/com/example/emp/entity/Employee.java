package com.example.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.emp.dto.EmployeeDto;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String name;

	@Column
	private Long mobileNo;
	
	@OneToOne
	@JoinColumn(name = "designation_id", referencedColumnName = "id")
	private Designation designation;

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

	
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public EmployeeDto convertTODTO() {

		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(this.getId());
		if(this.getDesignation()!=null)
		{
			employeeDto.setDesignationDto(this.getDesignation().convertTODTO());
		}
		employeeDto.setMobileNo(this.getMobileNo());
		employeeDto.setName(this.getName());
		
	

		return employeeDto;
	}

}
