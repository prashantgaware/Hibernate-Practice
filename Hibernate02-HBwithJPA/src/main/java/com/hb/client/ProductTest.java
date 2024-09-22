package com.hb.client;

import java.time.LocalDateTime;

import com.hb.dao.IProductDAO;
import com.hb.dao.ProductDAOImpl;
import com.hb.entity.ProductEntity;

public class ProductTest {
	
	public static void main(String[] args) {
		
		IProductDAO dao = new ProductDAOImpl();
		
		LocalDateTime ldt = null;
		
		ProductEntity product = new ProductEntity();
		product.setProductId(1);
		product.setProductName("IPhone");
		product.setQuantity(10);
		product.setCreatedOn(ldt.now());
		product.setUpdatedOn(ldt.now());
		
		dao.saveProduct(product);
	}
}
