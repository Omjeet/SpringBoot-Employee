package com.example.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.emp.dto.DesignationDto;

@Entity
@Table(name = "Designation")
public class Designation {
	@Id
	private Integer id;

	@Column
	private String name;

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

	public DesignationDto convertTODTO (){
		DesignationDto designationDto= new DesignationDto();
		designationDto.setId(this.getId());
		designationDto.setName(this.getName());
		return designationDto;
		
	}
}
