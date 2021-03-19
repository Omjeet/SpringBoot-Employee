package com.example.emp.service.intf;

import java.util.List;

import com.example.emp.dto.DesignationDto;

public interface DesignationService {

	public List<DesignationDto> getDesignationDtos();

	public DesignationDto getSingleDesignationDtobyId(Integer id);

	public void registerDesignation(DesignationDto designationDto);
}
