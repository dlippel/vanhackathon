package ca.skip.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ProductEntity {

	@Id
	private long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private BigDecimal price;

	@Column
	private long storeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STORE_ID", insertable = false, updatable = false)
	private StoreEntity store;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public long getStoreId() {
		return storeId;
	}

	public StoreEntity getStore() {
		return store;
	}

}
