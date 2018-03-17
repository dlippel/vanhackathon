package ca.skip.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ca.skip.model.CousineEntity;

@Repository
public class CousineDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<CousineEntity> listAll() {
		return entityManager.createNamedQuery("CousineEntity.selectAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CousineEntity> searchByNameLike(String filter) {
		final Query query = entityManager.createNamedQuery("CousineEntity.selectAll");
		query.setParameter("filter", '%' + filter + '%');
		return query.getResultList();
	}

}
