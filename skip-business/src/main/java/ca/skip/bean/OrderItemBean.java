package ca.skip.bean;

import java.math.BigDecimal;

import ca.skip.model.OrderItemEntity;

public class OrderItemBean {

	private long id;
	private long orderId;
	private long productId;
	private BigDecimal price;
	private long quantity;
	private BigDecimal total;

	private ProductBean product;

	public OrderItemBean() {
		// for jackson
	}

	public OrderItemBean(OrderItemEntity item) {
		super();

		this.id = item.getId();
		this.orderId = item.getOrderId();
		this.productId = item.getProductId();
		this.price = item.getPrice();
		this.quantity = item.getQuantity();
		this.total = item.getTotal();

		this.product = new ProductBean(item.getProduct());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

}
