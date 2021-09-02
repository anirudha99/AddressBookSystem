package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressMain {

	static List<Contact> Clist =new ArrayList<>(); //List to contain contact details

	static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!"); //Welcome message

		final int EXIT=10; //exit value

		int choice=0;
		while(choice != EXIT) {

			System.out.println("Address book options");
			System.out.println("1) Add Contact\n2) Edit Contact(not done)\n3) Display Contact\n"+EXIT+" to exit");
			Scanner r = new Scanner(System.in);
			choice=r.nextInt(); //take user choice

			switch(choice)
			{
			case 1:addContact(); //Add new contact
			break;
//			case 2: editContact(); //Edit contact(not done)
//			break;
			case 3:displayContact(); //display
			break;

			}
		}
		System.out.println("Goodbye!");
	}

	/**
	 * @Method to add contact
	 */
	public static void addContact() {
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
	}
	
	/**
	 * @method to display contact
	 */
	public static void displayContact() {
		for(Contact contact:Clist)
			System.out.println(contact);
	}

}
