package ca.skip.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class OrderEntity {

	@Id
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STORE_ID", insertable = false, updatable = false)
	private StoreEntity store;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", insertable = false, updatable = false)
	private CustomerEntity customer;

	@OneToMany(mappedBy = "order")
	private List<OrderItemEntity> items;

	OrderEntity() {
		// for hibernate
	}

	public OrderEntity(long customerId, String deliveryAddress, String contact, long storeId, String status,
			ZonedDateTime lastUpdate) {
		this.customerId = customerId;
		this.deliveryAddress = deliveryAddress;
		this.contact = contact;
		this.storeId = storeId;
		this.status = status;
		this.lastUpdate = lastUpdate;
	}

	public long getId() {
		return id;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public ZonedDateTime getLastUpdate() {
		return lastUpdate;
	}

	public long getStoreId() {
		return storeId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public StoreEntity getStore() {
		return store;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public List<OrderItemEntity> getItems() {
		return items;
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (OrderItemEntity item : items) {
			total = total.add(item.getTotal());
		}
		return total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
