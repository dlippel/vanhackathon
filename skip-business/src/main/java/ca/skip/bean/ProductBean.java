package ca.skip.bean;

import java.math.BigDecimal;

import ca.skip.model.ProductEntity;

public class ProductBean {

	private final ProductEntity product;

	public ProductBean(ProductEntity product) {
		super();
		this.product = product;
	}

	public long getId() {
		return product.getId();
	}

	public long getStoreId() {
		return product.getStoreId();
	}

	public String getName() {
		return product.getName();
	}

	public String getDescription() {
		return product.getDescription();
	}

	public BigDecimal getPrice() {
		return product.getPrice();
	}

}
