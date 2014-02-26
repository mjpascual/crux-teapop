package com.upou.teapop.util;

import java.util.Collections;
import java.util.List;

import com.upou.teapop.data.Category;
import com.upou.teapop.data.Menu;

public class MenuDisplayHelper {
	public static void sort(Menu menu){
		
		// sort additionals
		if (menu.getAdditionalSection() != null && !menu.getAdditionalSection().getCategories().isEmpty()){
			sortCategoryMenuItems(menu.getAdditionalSection().getCategories());
		}
		
		// sort beverages
		if (menu.getBeveragesSection() != null && !menu.getBeveragesSection().getCategories().isEmpty()){
			sortCategoryMenuItems(menu.getBeveragesSection().getCategories());
		}
	}
	
	private static void sortCategoryMenuItems(List<Category> section){

		for (Category category : section) {
			Collections.sort(category.getItems());
		}
		
	}
}
