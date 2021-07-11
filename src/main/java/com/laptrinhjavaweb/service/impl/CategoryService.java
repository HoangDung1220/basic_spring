package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.IcategoryService;

@Service
public class CategoryService implements IcategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> list = categoryRepository.findAll();
		List<CategoryDTO> listDto = new ArrayList<CategoryDTO>();
		for (CategoryEntity category : list) {
			CategoryDTO dto = new CategoryDTO();
			dto.setId(category.getId());
			dto.setDescription(category.getDescription());
			dto.setName(category.getName());
			listDto.add(dto);
		}
		return listDto;
	}

}
