package ca.skip.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class StoreEntity {

	@Id
	private long id;

	@Column
	private String name;

	@Column
	private String address;

	@Column(name = "COUSINE_ID")
	private long cousineId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUSINE_ID", insertable = false, updatable = false)
	private CousineEntity cousine;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CousineEntity getCousine() {
		return cousine;
	}

	public long getCousineId() {
		return cousineId;
	}

	public void setCousine(CousineEntity cousine) {
		this.cousine = cousine;
	}

}
