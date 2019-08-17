package com.communitydropin.CommunityDropInBackend.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodOrder {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JsonIgnore
	private HeadOfHousehold hoh;

	private int size;

	private LocalDate date;
	
	private boolean fulfilled;

	public FoodOrder(HeadOfHousehold hoh, LocalDate date) {
		this.hoh = hoh;
		this.size = hoh.getHouseSize();
		this.date = date;
		this.fulfilled = false;
	}

	@SuppressWarnings("unused")
	private FoodOrder() {

	}

	public Long getId() {
		return id;
	}

	public String getHohFirstName() {
		return hoh.getFirstName();
	}
	
	public String getHohLastName() {
		return hoh.getLastName();
	}

	public int getSize() {
		return size;
	}

	public String getDate() {
		return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	public boolean isFulfilled() {
		return fulfilled;
	}
	
	public void accept() {
		fulfilled = true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + size;
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
		FoodOrder other = (FoodOrder) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
}
