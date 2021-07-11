package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.CategoryDTO;

public interface IcategoryService {
	public List<CategoryDTO> findAll();
}
