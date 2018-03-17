package ca.skip.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.bean.CousineBean;
import ca.skip.bean.StoreBean;
import ca.skip.service.CousineService;
import ca.skip.service.StoreService;

@RestController
public class CousineRestController extends AbstractRestController {

	private CousineService cousineService;
	private StoreService storeService;

	@Autowired
	public CousineRestController(CousineService service, StoreService storeService) {
		this.cousineService = service;
		this.storeService = storeService;
	}

	@RequestMapping(value = "/Cousine", method = RequestMethod.GET)
	public ResponseEntity<List<CousineBean>> listar() {
		return ResponseEntity.ok(cousineService.listAll());
	}

	@RequestMapping(value = "/Cousine/search/{searchText}", method = RequestMethod.GET)
	public ResponseEntity<List<CousineBean>> listar(@PathVariable String searchText) {
		return ResponseEntity.ok(cousineService.searchByNameLike(searchText));
	}

	@RequestMapping(value = "/Cousine/{cousineId}/stores", method = RequestMethod.GET)
	public ResponseEntity<List<StoreBean>> listar(@PathVariable long cousineId) {
		return ResponseEntity.ok(storeService.listByCousine(cousineId));
	}

}
