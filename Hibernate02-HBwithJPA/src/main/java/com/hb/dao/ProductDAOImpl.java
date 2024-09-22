package com.hb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hb.entity.ProductEntity;

public class ProductDAOImpl implements IProductDAO {
	
	EntityManagerFactory factory;
	
	public ProductDAOImpl() {
		try {
	        factory = Persistence.createEntityManagerFactory("test");
	        System.out.println("EntityManagerFactory created successfully!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void saveProduct(ProductEntity product) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(product);
			tx.commit();
			System.out.println("Product is persisted..");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Product failed to persist..");
		} finally {
			entityManager.close();
		}
	}

	@Override
	public ProductEntity loadProduct(int productid) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity p = entityManager.find(ProductEntity.class, productid);
		entityManager.close();
		
		return p;
	}

	@Override
	public ProductEntity updateProduct(int productId, int new_quantity) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		ProductEntity p = entityManager.find(ProductEntity.class, productId);
		try {
			p.setQuantity(new_quantity);
			entityManager.merge(p);
			tx.commit();
			System.out.println("Product is updated..");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Product failed to update..");
		} finally {
			entityManager.close();
		}
		
		return p;
	}

	@Override
	public void deleteProduct(int productId) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		ProductEntity p = entityManager.find(ProductEntity.class, productId);
		try {
			entityManager.remove(p);
			tx.commit();
			System.out.println("Product is updated..");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("Product failed to update..");
		} finally {
			entityManager.close();
		}
	}

}
