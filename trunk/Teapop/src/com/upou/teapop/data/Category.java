package com.upou.teapop.data;

import java.util.List;

public class Category {
	
	private int categoryId;
	
	private String main;
	
	private String name;
	
	private String image;
	
	private String desc;
	
	private String showSML;
	
	private List<MenuItem> items;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getShowSML() {
		return showSML;
	}

	public void setShowSML(String showSML) {
		this.showSML = showSML;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
}
