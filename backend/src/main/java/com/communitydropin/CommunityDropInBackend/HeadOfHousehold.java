package com.communitydropin.CommunityDropInBackend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
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
	private LocalDate dateOfBirth;
	@ElementCollection
	private List<Calendar> datesReceived; //if im wrong we will come back to fix it
	private String firstName;
	
	
	public HeadOfHousehold(String firstName, String lastName, String address, Long phoneNumber, boolean deliveryStatus, int houseSize, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.deliveryStatus = deliveryStatus;
		this.houseSize = houseSize;
		this.dateOfBirth = dateOfBirth;
		this.datesReceived = new ArrayList<Calendar>();
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
	public LocalDate getDateofBirth() {
		return dateOfBirth;
	}
	public List<Calendar> getDatesReceived() {
		return datesReceived;
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
