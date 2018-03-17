package ca.skip.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Object entity) {
		entityManager.persist(entity);
	}

	public <T> T get(Class<T> entityClass, long id) {
		return entityManager.find(entityClass, id);
	}
}
