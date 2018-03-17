package ca.skip.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DAOUtils {

	@SuppressWarnings("unchecked")
	public static <T> List<T> list(EntityManager entityManager, String namedQuery) {
		final Query query = entityManager.createNamedQuery(namedQuery);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> list(EntityManager entityManager, String namedQuery, Map<String, Object> params) {
		final Query query = entityManager.createNamedQuery(namedQuery);
		params.forEach(query::setParameter);
		return query.getResultList();
	}

}
