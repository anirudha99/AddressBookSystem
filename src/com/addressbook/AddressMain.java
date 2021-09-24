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
					+ "5) Delete Contact\n6) Search by place\n"+EXIT+" to exit");
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
			}
		}
		System.out.println("Goodbye!");
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
		System.out.println("Enter the city or state name");
		String place = sc.next();
		int count = 0;

		for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.search(place);
			count += obj.search(place);
		}
		System.out.println(count+" contacts found based on your choice of place");
	}

}
