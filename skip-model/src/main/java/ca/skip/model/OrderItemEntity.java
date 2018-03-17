package ca.skip.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderItemEntity {

	@Id
	private long id;

	@Column
	private BigDecimal price;

	@Column
	private long quantity;

	@Column(name = "ORDER_ID")
	private long orderId;

	@Column(name = "ORDER_ID")
	private long productId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", insertable = false, updatable = false)
	private OrderEntity order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID", insertable = false, updatable = false)
	private ProductEntity product;

	public OrderItemEntity(BigDecimal price, long quantity, long orderId, long productId) {
		this.price = price;
		this.quantity = quantity;
		this.orderId = orderId;
		this.productId = productId;
	}

	public long getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public long getQuantity() {
		return quantity;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getProductId() {
		return productId;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public BigDecimal getTotal() {
		return price.multiply(BigDecimal.valueOf(quantity));
	}

}
