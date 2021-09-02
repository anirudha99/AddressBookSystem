package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!"); //Welcome message
		
		Scanner sc=new Scanner(System.in);
		
		List<Contact> Clist =new ArrayList<>(); //List to contain contact details
		
		System.out.println("Enter the Contact Details");
		System.out.println("Enter the first name");
		String first_name=sc.nextLine();
		System.out.println("Enter the last name");
		String last_name=sc.nextLine();
		System.out.println("Enter the addres");
		String address=sc.nextLine();
		System.out.println("Enter the city");
		String city=sc.nextLine();
		System.out.println("Enter the state");
		String state=sc.nextLine();
		System.out.println("Enter the zip code");
		String zip=sc.nextLine();
		System.out.println("Enter the phone Number");
		String phone_number=sc.nextLine();
		System.out.println("Enter the email Id ");
		String email=sc.nextLine();
		
		Contact contact = new Contact(first_name,last_name,address,city,state,zip,phone_number,email);
		
		Clist.add(contact); //Add to list
		
		Clist.forEach(System.out::println);
		
	}

}
