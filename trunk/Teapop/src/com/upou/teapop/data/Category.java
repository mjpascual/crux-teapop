package com.upou.teapop.data;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private int categoryId;
	
	private String name;
	
	private String image;
	
	private String desc;
	
	private boolean showSML;
	
	private List<MenuItem> items;

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

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean isShowSML() {
		return showSML;
	}

	public void setShowSML(boolean showSML) {
		this.showSML = showSML;
	}

}
