package ca.skip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.skip.bean.OrderBean;
import ca.skip.dao.GenericDAO;
import ca.skip.model.OrderEntity;

@Service
public class OrderService {

	private GenericDAO dao;
	private OrderItemService itemService;

	@Autowired
	public OrderService(GenericDAO dao, OrderItemService itemService) {
		this.dao = dao;
		this.itemService = itemService;
	}

	public Optional<OrderBean> get(long id) {
		return Optional.ofNullable(new OrderBean(dao.get(OrderEntity.class, id)));
	}

	public void placeOrder(OrderBean bean) {
		final OrderEntity order = new OrderEntity(bean.getCustomerId(), bean.getDeliveryAddress(), bean.getContact(),
				bean.getStoreId(), bean.getStatus(), bean.getLastUpdate());
		dao.persist(order);

		bean.getItems().forEach(item -> itemService.placeOrder(order, item));
	}

}
