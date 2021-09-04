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
			System.out.println("1) Add Contact\n2) Edit Contact\n3) Display Contact\n4) Delete Contact\n"+EXIT+" to exit");
			Scanner s = new Scanner(System.in);
			choice=s.nextInt(); //take user choice

			switch(choice) {
			case 1:addContact(); //Add new contact
			break;
			case 2:System.out.println("Enter the contact name to be edited");	
			String name=sc.next();
			editContact(name); //Edit contact(not done)
			break;
			case 3:displayContact(); //display
			break;
			case 4:System.out.println("Enter First name of the contact to be deleted");
			String first_name = sc.next();
			System.out.println("Enter Last name of the contact to be deleted");
			String last_name = sc.next();
			deleteContact(first_name,last_name);
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
	 * @method to edit contacts
	 * @param name
	 */
	public static void editContact(String name) {
		for(Contact item:Clist)
		{
			if(item.first_name.equals(name)) {
				Contact personedit = item;
				System.out.println("First Name:");
				String first_name=sc.next();
				personedit.first_name=first_name;
				System.out.println("Last Name:");
				String last_name=sc.next();
				personedit.last_name=last_name;
				System.out.println("Address:");
				String address=sc.next();
				personedit.address=address;
				System.out.println("City:");
				String city=sc.next();
				personedit.city=city;
				System.out.println("State:");
				String state=sc.next();
				personedit.state=state;
				System.out.println("zip code:");
				String zip=sc.next();
				personedit.zip=zip;
				System.out.println("Phone number:");
				String phone_number=sc.next();
				personedit.phone_number=phone_number;
				System.out.println("E-mail:");
				String email=sc.next();
				personedit.email=email;
			}
			else
			{
				System.out.println("Match not found!");
			}
		}
	}

	/**
	 * @method to display contact
	 */
	public static void displayContact() {
		for(Contact contact:Clist)
			System.out.println(contact);
	}

	/**
	 * @method to delete contact using names
	 * @param first_name
	 * @param last_name
	 */
	public static void deleteContact(String first_name,String last_name) {
		for(Contact item:Clist) {
			if(item.first_name.equals(first_name) && item.last_name.equals(last_name) ) {
				Contact persondelete = item;
				Clist.remove(persondelete);
				System.out.println("Contact deleted!");
			}
			else {
				System.out.println("Person not found!");
			}
		}
	}

}
