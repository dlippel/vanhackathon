package ca.skip.bean;

import ca.skip.model.StoreEntity;

public class StoreBean {

	private final StoreEntity store;

	public StoreBean(StoreEntity store) {
		super();
		this.store = store;
	}

	public long getId() {
		return store.getId();
	}

	public String getName() {
		return store.getName();
	}

	public String getAddress() {
		return store.getAddress();
	}

	public long getCousineId() {
		return store.getCousineId();
	}

}
