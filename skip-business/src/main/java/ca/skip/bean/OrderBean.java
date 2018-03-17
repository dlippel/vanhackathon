package ca.skip.bean;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import ca.skip.model.OrderEntity;

public class OrderBean {

	private long id;

	@Column
	private ZonedDateTime date;

	@Column(name = "DELIVERY_ADDRESS")
	private String deliveryAddress;

	@Column
	private String contact;

	@Column(name = "LAST_UPDATE")
	private ZonedDateTime lastUpdate;

	@Column(name = "STORE_ID")
	private long storeId;

	@Column(name = "CUSTOMER_ID")
	private long customerId;

	@Column
	private String status;
	private List<OrderItemBean> items;

	public OrderBean(OrderEntity order) {
		this.id = order.getId();
		this.deliveryAddress = order.getDeliveryAddress();
		this.contact = order.getContact();
		this.lastUpdate = order.getLastUpdate();
		this.storeId = order.getStoreId();
		this.customerId = order.getCustomerId();

		this.items = new ArrayList<>();
		order.getItems().stream().map(OrderItemBean::new).forEach(this.items::add);
	}

	public long getId() {
		return this.id;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(ZonedDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItemBean> getItems() {
		return items;
	}

	public void setItems(List<OrderItemBean> items) {
		this.items = items;
	}

}
