package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	public List<ProductDTO> findAll();
	public ProductDTO findOneById(int id);
}
