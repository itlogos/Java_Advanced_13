package ua.lviv.lgs.domain;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magazine")
public class Magazine {
	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Double subscribePrice;

	public Magazine() {
	}

	public Magazine(Integer id, String name, String description, Double subscribePrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.subscribePrice = subscribePrice;
	}

	public Magazine(String name, String description2, Double subscribePrice) {
		this.name = name;
		this.description = description2;
		this.subscribePrice = subscribePrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSubscribePrice() {
		return subscribePrice;
	}

	public void setSubscribePrice(Double subscribePrice) {
		this.subscribePrice = subscribePrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, subscribePrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Magazine other = (Magazine) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(description, other.description)
				&& Objects.equals(subscribePrice, other.subscribePrice);
	}

	@Override
	public String toString() {
		return "Magazine id = " + id + ", name = " + name + ", description = " + description + ", subscribePrice = "
				+ subscribePrice;
	}

}