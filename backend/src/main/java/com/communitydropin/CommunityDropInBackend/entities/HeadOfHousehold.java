package com.communitydropin.CommunityDropInBackend.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HeadOfHousehold {

	@Id
	@GeneratedValue
	private Long id;

	private String lastName;
	private Long phoneNumber;
	private String address;
	private boolean deliveryStatus;
	private int houseSize;
	private LocalDate dateOfBirth;
	@OneToMany(mappedBy="hoh")
	private List<FoodOrder> foodOrders;
	private String firstName;

	public HeadOfHousehold(String firstName, String lastName, String address, Long phoneNumber, boolean deliveryStatus,
			int houseSize, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.deliveryStatus = deliveryStatus;
		this.houseSize = houseSize;
		this.dateOfBirth = dateOfBirth;
		this.foodOrders = new ArrayList<FoodOrder>();
	}

	@SuppressWarnings("unused")
	private HeadOfHousehold() {

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}

	public int getHouseSize() {
		return houseSize;
	}

	public Long getId() {
		return id;
	}

	public String getDateOfBirth() {
		return dateOfBirth.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	public List<FoodOrder> getFoodOrders() {
		return foodOrders;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setHouseSize(int houseSize) {
		this.houseSize = houseSize;

	}

	public void changeDeliveryStatus() {
		deliveryStatus = !deliveryStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + (deliveryStatus ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + houseSize;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeadOfHousehold other = (HeadOfHousehold) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (deliveryStatus != other.deliveryStatus)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (houseSize != other.houseSize)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
}
