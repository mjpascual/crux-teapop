package com.upou.teapop.data;

import java.util.ArrayList;
import java.util.List;

public class MenuSection {
	private List<Category> categories;

	public List<Category> getCategories() {
		if (categories == null){
			categories = new ArrayList<Category>();
		}
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
