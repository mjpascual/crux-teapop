package com.upou.teapop.data;


public class Menu {

	private MenuSection beveragesSection;
	
	private MenuSection additionalSection;

	public void setBeveragesSection(MenuSection beverages) {
		this.beveragesSection = beverages;
	}

	public MenuSection getBeveragesSection() {
		return beveragesSection;
	}

	public void setAdditionalSection(MenuSection additional) {
		this.additionalSection = additional;
	}

	public MenuSection getAdditionalSection() {
		return additionalSection;
	}
	
}
