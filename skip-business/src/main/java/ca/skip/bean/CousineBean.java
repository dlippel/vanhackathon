package ca.skip.bean;

import ca.skip.model.CousineEntity;

public class CousineBean {

	private final CousineEntity cousine;

	public CousineBean(CousineEntity cousine) {
		this.cousine = cousine;
	}

	public long getId() {
		return cousine.getId();
	}

	public String getName() {
		return cousine.getName();
	}

}
