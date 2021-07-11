package com.laptrinhjavaweb.dto;

public class MenuDTO {

	private int id;
	private String url;
	private String name;
	
	
	
	public MenuDTO() {
		super();
	}



	public MenuDTO(int id, String url, String name) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
