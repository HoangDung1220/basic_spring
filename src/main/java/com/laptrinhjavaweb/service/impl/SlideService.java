package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.SlideDTO;
import com.laptrinhjavaweb.entity.SlideEntity;
import com.laptrinhjavaweb.repository.SlideRepository;
import com.laptrinhjavaweb.service.ISlideService;

@Service
public class SlideService implements ISlideService{

	@Autowired
	private SlideRepository slideRepository;
	
	@Override
	public List<SlideDTO> findAll() {
		List<SlideEntity> list = slideRepository.findAll();
		
		List<SlideDTO> listDTO = new ArrayList<SlideDTO>();
		for (SlideEntity slide : list) {
			SlideDTO dto = new SlideDTO();
			dto.setId(slide.getId());
			dto.setCaption(slide.getCaption());
			dto.setContent(slide.getContent());
			dto.setImg(slide.getImg());
			listDTO.add(dto);
		}
		return listDTO;
	}

}
