package com.upou.teapop.data;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private String categoryId;
	
	private String main;
	
	private String name;
	
	private String image;
	
	private String desc;
	
	private String disp;
	
	private boolean showSML;
	
	private List<MenuItem> items;

	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
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

	public String getDisp() {
		return disp;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}

	public boolean getShowSML() {
		return showSML;
	}

	public void setShowSML(boolean showSML) {
		this.showSML = showSML;
	}

	public List<MenuItem> getItems() {
		if(items == null){
			items = new ArrayList<MenuItem>();
		}
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	
}
