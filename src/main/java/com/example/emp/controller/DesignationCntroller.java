package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.dto.DesignationDto;
import com.example.emp.service.intf.DesignationService;

@RestController
@RequestMapping(value = "designation")
public class DesignationCntroller {

	@Autowired
	private DesignationService DesignationService;

	@GetMapping(path = "all")
	public List<DesignationDto> getDesignationDtos() {
		return DesignationService.getDesignationDtos();
	}

	@GetMapping(path = "/{id}")
	public DesignationDto getSingleDesignationDto(@PathVariable(name = "id") Integer id) {

		return DesignationService.getSingleDesignationDtobyId(id);

	}

	@PostMapping
	public void registerDesignation(@RequestBody DesignationDto designationDto) {

		DesignationService.registerDesignation(designationDto);
	}

}
