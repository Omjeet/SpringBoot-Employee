package com.example.emp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class EmployeeDto {
	private Integer id;
	private String name;
	private Long mobileNo;
	private DesignationDto designationDto;

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

	public DesignationDto getDesignationDto() {
		return designationDto;
	}

	public void setDesignationDto(DesignationDto designationDto) {
		this.designationDto = designationDto;
	}
	

}
