package ca.skip.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.bean.OrderBean;
import ca.skip.service.OrderService;

@RestController
public class OrderRestController extends AbstractRestController {

	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping(value = "/Order/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrder(@PathVariable long orderId) {
		final Optional<OrderBean> optional = orderService.get(orderId);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/Order", method = RequestMethod.POST)
	public ResponseEntity<Void> placeOrder(@RequestBody OrderBean bean) {
		orderService.placeOrder(bean);
		return ResponseEntity.ok().build();
	}

}
