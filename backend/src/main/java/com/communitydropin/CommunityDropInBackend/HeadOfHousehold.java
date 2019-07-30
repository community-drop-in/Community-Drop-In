package com.communitydropin.CommunityDropInBackend;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Set<HeadOfHousehold> dateofBirth = new HashSet<HeadOfHousehold>();
	private Set<HeadOfHousehold> datesReceives = new HashSet<HeadOfHousehold>();
	private String firstName;
	
	
	public HeadOfHousehold(String firstName, String lastName, String address, Long phoneNumber, boolean deliveryStatus, int houseSize) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.deliveryStatus = deliveryStatus;
		this.houseSize = houseSize;
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
	public Set<HeadOfHousehold> getDateofBirth() {
		return dateofBirth;
	}
	public Set<HeadOfHousehold> getDatesReceives() {
		return datesReceives;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
