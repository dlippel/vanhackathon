package ca.skip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.skip.bean.CousineBean;
import ca.skip.dao.CousineDAO;
import ca.skip.model.CousineEntity;

@Service
public class CousineService {

	private CousineDAO dao;

	@Autowired
	public CousineService(CousineDAO dao) {
		this.dao = dao;
	}

	public List<CousineBean> listAll() {
		final List<CousineEntity> data = dao.listAll();
		return convert(data);
	}

	public List<CousineBean> searchByNameLike(String filter) {
		final List<CousineEntity> data = dao.searchByNameLike(filter);
		return convert(data);
	}

	private List<CousineBean> convert(final List<CousineEntity> data) {
		return data.stream().map(CousineBean::new).collect(Collectors.toList());
	}

}
