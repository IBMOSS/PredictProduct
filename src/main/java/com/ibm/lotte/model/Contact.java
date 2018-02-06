package com.ibm.lotte.model;

import lombok.Data;

@Data
public class Contact {

	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;

	public Contact() {
	}

	public Contact(String firstName, String lastName, String phoneNumber, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

}