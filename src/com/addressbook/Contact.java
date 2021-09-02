package com.addressbook;

public class Contact {

	//class variables
	public String first_name;
	public String last_name;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phone_number;
	public String email;

	/**
	 * @param first_name
	 * @param last_name
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone_number
	 * @param email
	 */
	public Contact(String first_name,String last_name,String address,String city,String state,String zip,String phone_number,String email)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.address  =address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone_number = phone_number;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [FirstName=" + first_name + ", LastName=" + last_name + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phone_number=" + phone_number + ", email=" + email
				+ "]";
	}

}
