package ca.skip.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ca.skip.model.OrderEntity;

@Repository
public class OrderDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public OrderEntity get(long id) {
		return entityManager.find(OrderEntity.class, id);
	}

}
