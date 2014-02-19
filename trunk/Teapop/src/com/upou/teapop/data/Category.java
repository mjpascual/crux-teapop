package com.upou.teapop.data;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private int categoryId;
	
	private String name;
	
	private String image;
	
	private String desc;
	
	private List<Item> items;

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

	public List<Item> getItems() {
		if (items == null){
			items = new ArrayList<Item>();
		}
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}