package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.MenuDTO;

public interface IMenuService {
	public List<MenuDTO> findAll();
}
