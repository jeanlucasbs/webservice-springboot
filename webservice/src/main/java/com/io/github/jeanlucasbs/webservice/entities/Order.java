package com.io.github.jeanlucasbs.webservice.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.io.github.jeanlucasbs.webservice.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "fk_client_id")
	private User client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	private Integer orderStatus;
	
	public Order() {}

	public Order(Long iD, Instant moment, OrderStatus orderStatus, User client) {
		super();
		ID = iD;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();	
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(ID, other.ID);
	}
}
