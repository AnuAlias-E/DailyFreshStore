package com.training.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "stores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@EqualsAndHashCode.Include
	private int storeId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id", nullable = false)
	private Contact contact;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	

}
