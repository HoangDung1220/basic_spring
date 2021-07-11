package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	

	@Override
	public List<ProductDTO> findAll() {
	
		List<ProductEntity> listEntity = productRepository.findFirst10ByOrderByName();

		List<ProductDTO> list = new ArrayList<ProductDTO>();
		for (int index = 0; index < listEntity.size(); index++) {
			ProductEntity product = listEntity.get(index);
			if (product != null && product.getColors().size()>0) {
					for (int i =0;i<product.getColors().size();i++) {
					 ProductDTO dto = new ProductDTO();
				//	 dto.setCategory_id(productRepository.findOne(product.getId()).getCategory().getId());
					 dto.setCategory_id(product.getCategory().getId());
					 product.setCategory(null);
					 Gson gson = new Gson(); 
					 String jsonString = gson.toJson(product); 
					 dto = gson.fromJson(jsonString, ProductDTO.class);
					 dto.setIdColor(product.getColors().get(i).getId());
					 dto.setImg(product.getColors().get(i).getImg());
					 dto.setNameColor(product.getColors().get(i).getName());
					 dto.setCodeColor(product.getColors().get(i).getCode());
					 list.add(dto);
					}	
			}
		}
		return list;
	}

	@Override
	public ProductDTO findOneById(int id) {
		ProductEntity product = productRepository.findOne(1);
		/*
		 * dto.setId(product.getId());
		 * dto.setCategory_id(product.getCategory().getId());
		 * dto.setDetail(product.getDetail()); dto.setHightLight(product.isHighLight());
		 * dto.setNewProduct(product.isNewProduct()); dto.setName(product.getName());
		 * dto.setCreatedAt(product.getCreatedAt());
		 * dto.setUpdatedAt(product.getUpdatedAt()); dto.setPrice(product.getPrice());
		 * dto.setSale(product.getSale()); dto.setSize(product.getSize());
		 * dto.setTitle(product.getTitle());
		 * 
		 */
		ProductDTO dto = new ProductDTO();
		dto.setCategory_id(product.getCategory().getId());
		product.setCategory(null);
	
		return dto;
	}

}
