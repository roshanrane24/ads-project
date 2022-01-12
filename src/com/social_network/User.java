package com.social_network;

import com.utils.PrimaryKey;

public class User implements PrimaryKey<Integer> {
	@Override
	public String toString() {
		return "User Id : " + uId + "\tName : " + name + "\tGender : " + gender;
	}

	private static int id;
	private int uId;
	private String name;
	private Gender gender;

	static {
		User.id = 1;
	}

	public User(String name, Gender gender) {
		this.uId = User.id++;
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public Integer getKey() {
		return uId;
	}

}
