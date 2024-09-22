package com.hb.dao;

import com.hb.entity.ProductEntity;

public interface IProductDAO {
	
	void saveProduct(ProductEntity product);
	
	ProductEntity loadProduct(int productid);
	
	ProductEntity updateProduct(int productId, int new_unit_price);
	
	void deleteProduct(int productId);

}
