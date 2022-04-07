package com.cabapp.models;

public class Details {
	private String name;
	private Long phone;
	private String address;
	private String gender;
	private Integer age;

	public Details(String name, Long phone, String address, String gender, Integer age) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.age = age;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Details [name=" + name + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", age="
				+ age + "]";
	}

}
