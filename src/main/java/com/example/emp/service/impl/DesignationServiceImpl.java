package com.example.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.dto.DesignationDto;
import com.example.emp.entity.Designation;
import com.example.emp.repository.DesignationRepository;
import com.example.emp.service.intf.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepo;

	//get list
	@Override
	public List<DesignationDto> getDesignationDtos() {
		// TODO Auto-generated method stub
		List<DesignationDto> designationDtos = new ArrayList<DesignationDto>();
		List<Designation> designations = designationRepo.findAll();

		if (!designations.isEmpty()) {
			designations.forEach(i -> designationDtos.add(i.convertTODTO()));
		}

		return designationDtos;
	}

	//get single designation
	@Override
	public DesignationDto getSingleDesignationDtobyId(Integer id) {
		// TODO Auto-generated method stub
		// DesignationDto designationDto = new DesignationDto();

		Designation designation = designationRepo.getOne(id);
		DesignationDto designationDto = designation.convertTODTO();

		return designationDto;

	}

	//post method
	@Override
	public void registerDesignation(DesignationDto designationDto) {
		// TODO Auto-generated method stub
		Designation designation = new Designation();
		designation.setName(designationDto.getName());
		designation.setId(designationDto.getId());
		designationRepo.save(designation);		
		
	}

}
