package com.addressbook;

public class Contact {
	
	//class variables
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone_number;
	private String email;
	
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
		return "Contact [first_name=" + first_name + ", last_name=" + last_name + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", phone_number=" + phone_number + ", email=" + email
				+ "]";
	}
	
//	/**
//	 * @method to display contact details
//	 */
//	public void display()
//	{
//		System.out.println("First Name:"+first_name);
//		System.out.println("Last Name:"+last_name);
//		System.out.println("Address:"+address);
//		System.out.println("City:"+city);
//		System.out.println("State:"+state);
//		System.out.println("Zip:"+zip);
//		System.out.println("Phone number"+phone_number);
//		System.out.println("E-mail:"+email);
//	}

}
