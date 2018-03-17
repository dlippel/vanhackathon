package ca.skip.service;

import org.springframework.beans.factory.annotation.Autowired;

import ca.skip.bean.OrderItemBean;
import ca.skip.dao.GenericDAO;
import ca.skip.model.OrderEntity;
import ca.skip.model.OrderItemEntity;

public class OrderItemService {

	private GenericDAO dao;

	@Autowired
	public OrderItemService(GenericDAO dao) {
		this.dao = dao;
	}

	public void placeOrder(OrderEntity order, OrderItemBean bean) {
		OrderItemEntity item = new OrderItemEntity(bean.getPrice(), bean.getQuantity(), order.getId(),
				bean.getProductId());
		dao.persist(item);
	}

}
