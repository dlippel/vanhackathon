package ca.skip.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ca.skip.model.StoreEntity;

@Repository
public class StoreDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<StoreEntity> listByCousine(long cousineId) {
		return DAOUtils.list(entityManager, "Store.selectByCousineId",
				Collections.singletonMap("cousineId", cousineId));
	}

}
