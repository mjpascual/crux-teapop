package com.upou.teapop.data;

public class MenuItem implements Comparable<MenuItem>{

	private int itemId;

	private int catId;

	private int dispPosition;

	private String itemCode;

	private String name;

	private String desc;

	private boolean featured;

	private boolean hidden;
	
	private String size;
	
	private Price price;
	
	private String category;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getDispPosition() {
		return dispPosition;
	}

	public void setDispPosition(int dispPosition) {
		this.dispPosition = dispPosition;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public int compareTo(MenuItem compareMenuItem) {
		int compareDispPosition = compareMenuItem.getDispPosition(); 
		 
		//ascending order
		return this.dispPosition - compareDispPosition;
	}
	
	

	
	
}
