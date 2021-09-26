package com.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressMain {

	static Map<String,AddressBook> addressBook = new HashMap<>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!"); //Welcome message

		final int EXIT = 10; //exit value

		int choice = 0;
		while(choice != EXIT) {

			System.out.println("Address book options");
			System.out.println("1) Add Address Book\n2) Add Contact\n3) Edit Contact\n4) Display Contacts in Addressbook\n"
					+ "5) Delete Contact\n6) Search by place\n"
					+ "7) Sort by name\n8) Sort by place\n"+EXIT+" to exit");
			choice = sc.nextInt(); 		//take user choice

			switch(choice) {
			case 1:
				addAddressBook(); 		//Add address book
				break;
			case 2:
				addContact(); 			//Add new contact
				break;
			case 3:
				editContact(); 			//Edit contact
				break;
			case 4:
				displayAddressbook(); 	//display contacts in address book
				break;
			case 5:
				deleteContact();		//delete contact
				break;
			case 6:
				searchPlace();
				break;
			case 7:
				sortByName();
				break;
			case 8:
				sortByPlace();
				break;
			}
		}
		System.out.println("Goodbye!");
	}


	private static void sortByPlace() {
		System.out.println("How do you wanna sort\n1:By Zip code\n2: By City name\n3: By State name");
		Scanner m = new Scanner(System.in);
		int ch = m.nextInt();
		switch(ch) {
		case 1:for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.sortZip();
		}
		break;
		case 2:for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.sortCity();
		}
		break;
		case 3:for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.sortState();
		}
		break;
		}		
	}


	private static void sortByName() {
		for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.sort();
		}
	}


	public static void addAddressBook() {
		System.out.println("Enter the addressbook name");
		String bookName = sc.next();

		AddressBook book = addressBook.get(bookName);
		if(book != null) {
			System.out.println("Already has a address book of that name! Enter new name!");
		}
		else {
			AddressBook addbook = new AddressBook(bookName);
			addressBook.put(bookName, addbook); //add address book
		}
	}

	/**
	 * @Method to add contact
	 */
	public static void addContact() {
		System.out.println("Enter the addressbook name");
		String addbook = sc.next();
		AddressBook book = addressBook.get(addbook);
		if(book == null) {
			System.out.println("Address book is not found!!");
		}
		else {
			addressBook.get(addbook).addContact(); //add
		}
	}

	/**
	 * @method to edit contact
	 */
	public static void editContact() {
		System.out.println("Enter the addressbook name");
		String bookName = sc.next();
		AddressBook addbook = addressBook.get(bookName);
		if(addbook == null) {
			System.out.println("Address book is not found!!");
		}
		else {
			addressBook.get(bookName).editContactPerson(); //edit
		}
	}

	/**
	 * @method to display contacts in addressbook
	 */
	public static void displayAddressbook() {
		System.out.println("Enter the addressbook name");
		String bookName = sc.next();
		AddressBook addbook=addressBook.get(bookName);
		if(addbook == null) {
			System.out.println("Address book is not found!!");
		}
		else
		{
			addbook.print(); //display
		}

	}

	/**
	 * @method to delete contact using names
	 */
	public static void deleteContact() {
		System.out.println("Enter the addressbook name");
		String bookName = sc.next();
		AddressBook addbook = addressBook.get(bookName);
		if(addbook == null) {
			System.out.println("Address book is not found!!");
		}
		else {
			addressBook.get(bookName).deleteContactPerson(); //delete
		}
	}

	/**
	 * Search method
	 */
	private static void searchPlace() {
		System.out.println("Enter the either\n 1: city name\n 2: state name");
		int choice = sc.nextInt();
		if (choice == 1) {
			Scanner r1 = new Scanner(System.in);
			System.out.println("Enter city name");
			String place = sc.next();
			int count = 0;
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				count += obj.searchCity(place);
			}
			System.out.println(count + " contact found based on place of your choice");
		}
		else if (choice == 2) {
			System.out.println("Enter state name");
			String place = sc.next();
			int count = 0;
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				count += obj.searchState(place);
			}
			System.out.println(count + " contact found based on place of your choice");
		}
	}

}
