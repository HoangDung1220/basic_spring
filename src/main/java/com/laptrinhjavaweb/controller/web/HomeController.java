package com.laptrinhjavaweb.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.SlideDTO;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.ISlideService;
import com.laptrinhjavaweb.service.IcategoryService;

@Controller(value ="homeControllerOfWeb")
public class HomeController extends BaseController{

	@Autowired
	private ISlideService slideService;
	
	@Autowired
	private IcategoryService categoryService;
	
	@Autowired
	private IProductService productService;
	
	
	@RequestMapping(value="/trang-chu",method=RequestMethod.GET)
	public ModelAndView homePage() {
		List<SlideDTO> listDto = slideService.findAll();
		List<CategoryDTO> listCategory = categoryService.findAll();
		_mav.addObject("listSlide",listDto);
		_mav.addObject("listCategory",listCategory);
		_mav.addObject("listProduct",productService.findAll());
		_mav.setViewName("web/home");
		return _mav;
	}
}
