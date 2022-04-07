package com.cabapp.models;

public class Driver {
	private Details details;
	private String registrationNumber;
	private Location<Integer, Integer> location;
	private Integer income = 0;
	private Boolean status = true;

	public Driver(Details details, String registrationNumber, Location<Integer, Integer> location) {
		super();
		this.details = details;
		this.registrationNumber = registrationNumber;
		this.location = location;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Location<Integer, Integer> getLocation() {
		return location;
	}

	public void setLocation(Location<Integer, Integer> location) {
		this.location = location;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Driver [details=" + details + ", registrationNumber=" + registrationNumber + ", location=" + location
				+ ", income=" + income + ", status=" + status + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Driver obj2 = (Driver) obj;
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		return (this.getDetails().getName().equals(obj2.getDetails().getName())
				&& this.getDetails().getAge() == (obj2.getDetails().getAge())
				&& this.getDetails().getGender().equals(obj2.getDetails().getGender()));
	}

}
