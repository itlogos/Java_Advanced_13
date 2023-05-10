package ua.lviv.lgs.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subscribe")
public class Subscribe{

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;

	@ManyToOne
	@JoinColumn(name = "magazine_id", referencedColumnName = "Id")
	private Magazine magazineId;

	@Column(name = "subscribe_date")
	private Date subscribeDate;



	public Subscribe() {
	}
	
	public Subscribe(String id, User userId, Magazine magazineId, Date subscribeDate) {
		this.id = id;
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeDate = subscribeDate;
	}

	public Subscribe(User userId, Magazine magazineId, Date subscribeDate) {
		this.userId = userId;
		this.magazineId = magazineId;
		this.subscribeDate = subscribeDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return userId;
	}

	public void setUser(User userId) {
		this.userId = userId;
	}

	public Magazine getMagazine() {
		return magazineId;
	}

	public void setMagazine(Magazine magazineId) {
		this.magazineId = magazineId;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, magazineId, subscribeDate, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscribe other = (Subscribe) obj;
		return Objects.equals(id, other.id) && Objects.equals(magazineId, other.magazineId)
				&& Objects.equals(subscribeDate, other.subscribeDate)
								&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "Subscribe id = " + id + ", userId = " + userId + ", magazineId = " + magazineId + ", subscribeDate = " + subscribeDate;
	}

}