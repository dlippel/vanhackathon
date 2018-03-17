package ca.skip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table
@Entity
@NamedQueries({

		@NamedQuery(name = "CousineEntity.selectAll", query = "select c from Cousine c"),
		@NamedQuery(name = "CousineEntity.selectByNameLike", query = "select c from Cousine c where c.name like :filter")

})
public class CousineEntity {

	@Id
	private Long id;

	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
