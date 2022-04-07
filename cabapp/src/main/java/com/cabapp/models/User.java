package com.cabapp.models;

public class User {
	private Details userDetails;
	private Location<Integer, Integer> location;

	public User(Details userDetails, Location<Integer, Integer> location) {
		super();
		this.userDetails = userDetails;
		this.location = location;
	}

	public Details getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Details userDetails) {
		this.userDetails = userDetails;
	}

	public Location<Integer, Integer> getLocation() {
		return location;
	}

	public void setLocation(Location<Integer, Integer> location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [userDetails=" + userDetails + ", location=" + location + "]";
	}

	@Override
	public boolean equals(Object obj) {
		User obj2 = (User) obj;
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		return (this.getUserDetails().getName().equals(obj2.getUserDetails().getName())
				&& this.getUserDetails().getAge() == (obj2.getUserDetails().getAge())
				&& this.getUserDetails().getGender().equals(obj2.getUserDetails().getGender()));
	}

}
