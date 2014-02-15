package com.upou.teapop.data;

import java.util.ArrayList;
import java.util.List;

public class Specials {
	
	private List<Promo> promos;

	public List<Promo> getPromos() {
		if (promos == null){
			promos = new ArrayList<Promo>();
		}
		return promos;
	}

	public void setPromos(List<Promo> promos) {
		this.promos = promos;
	}
}
