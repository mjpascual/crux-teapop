package com.upou.teapop.dao.test;

import static org.junit.Assert.*;

import java.util.List;


import org.junit.Ignore;
import org.junit.Test;

import com.upou.teapop.dao.PromoDao;
import com.upou.teapop.data.Promo;

public class PromoDaoTest {


	@Ignore
	@Test
	public void createPromo() {

		Promo promo = new Promo();
		promo.setPromoId(0);
		promo.setPromoCode("PMO-3");
		promo.setName("Promo 4");
		promo.setDesc("Promo 4");
		promo.setImage("promo3.jpg");
		
		PromoDao promoDao = new PromoDao();
		boolean result = promoDao.createPromo(promo);
        assertTrue(result);   
        
	}
	
	@Ignore
	@Test
	public void updatePromo() {
	
		Promo promo = new Promo();
		promo.setPromoId(3);
		promo.setPromoCode("PMO-3");
		promo.setName("Promo 3");
		promo.setDesc("Promo 3");
		promo.setImage("promo3.jpg");
		
		PromoDao promoDao = new PromoDao();
		boolean result = promoDao.createPromo(promo);
        assertTrue(result);   

	}
	
	@Ignore
	@Test
	public void retrievePromo() {
	
		PromoDao promoDao = new PromoDao();
		Promo cat = promoDao.retrievePromo(3);
        assertEquals(cat.getName(), "Promo 3");
		
	}
	
	@Ignore
	@Test
	public void retrieveCategories() {
	
		PromoDao promoDao = new PromoDao();
		List <Promo> cat = promoDao.retrieveCategories();
        assertEquals(cat.get(2).getName(), "Promo 3");
		
	}
	
	@Ignore
	@Test
	public void deletePromo() {
	
		PromoDao promoDao = new PromoDao();
		Boolean result = promoDao.deletePromo(3);
		assertTrue(result);   
		
	}


}
