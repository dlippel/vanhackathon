package ca.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.skip.bean.StoreBean;
import ca.skip.dao.StoreDAO;

@Service
public class StoreService {

	private StoreDAO dao;

	@Autowired
	public StoreService(StoreDAO dao) {
		super();
		this.dao = dao;
	}

	public List<StoreBean> listByCousine(long cousineId) {
		return dao.listByCousine(cousineId).stream().map(StoreBean::new).collect(Collectors.toList());
	}

}
