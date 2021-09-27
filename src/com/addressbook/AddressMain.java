package com.addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressMain {

	static Map<String,AddressBook> addressBook = new HashMap<>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!"); //Welcome message

		final int EXIT = 15; //exit value

		int choice = 0;
		while(choice != EXIT) {

			System.out.println("Address book options");
			System.out.println("1) Add Address Book\n2) Add Contact\n"
					+ "3) Edit Contact\n4) Display Contacts in Addressbook\n"
					+ "5) Delete Contact\n6) Search by place\n"
					+ "7) Sort by name\n8) Sort by place\n"
					+ "9) Read from file\n10) Write into file\n"
					+ "11) Read from CSV file\n12) Write into CSV file\n"
					+ "13) Read from json file\n14) Write into json file\n"
					+EXIT+" to exit");
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
				searchPlace();			//search by place
				break;
			case 7:
				sortByName();			//sort by name
				break;
			case 8:
				sortByPlace();			//sort by place
				break;
			case 9:
				readFile();				//file io operation - to read
				break;
			case 10:
				writeToFile();			//file io operation - to write
				break;
			case 11:
				readFromCsv();
				break;
			case 12:
				writeTocsv();
				break;
			case 13:
				readFromJson();
				break;
			case 14:
				writeToJson();
				break;
			}
		}
		System.out.println("Goodbye!");
	}


	private static void writeToJson() {
		String basePath = "/Users/anirudhasm/Desktop/eclipse-yml_training_workspace/AddressBookSystem/csvresource";
		System.out.println("Enter the address book you wanna write");
		String fileName = sc.next();
		AddressBook Book = addressBook.get(fileName);
		if (Book == null) {
			System.out.println("No book found");
			return;

		}
		addressBook.get(fileName).writeContactJson(basePath + "/" + fileName + ".json");

	}


	private static void readFromJson() {
		String basePath = "/Users/anirudhasm/Desktop/eclipse-yml_training_workspace/AddressBookSystem/csvresource";
		System.out.println("Enter the address book you wanna read");
		String filename = sc.next();
		File file = new File(basePath + "/" + filename + ".json");
		if (!file.exists()) {
			System.out.println("Address book not found");
			return;
		}
		AddressBook adBook = new AddressBook(filename);
		addressBook.put(filename, adBook);
		adBook.addContactJson(basePath + "/" + filename + ".json");

	}


	/**
	 * Method to write into the csv file
	 */
	private static void writeTocsv() {
		String basePath = "/Users/anirudhasm/Desktop/eclipse-yml_training_workspace/AddressBookSystem/csvresource";		
		System.out.println("Enter the address book you wanna write");
		String fileName = sc.next();
		AddressBook Book = addressBook.get(fileName);
		if (Book == null) {
			System.out.println("No book found");
			return;
		}
		addressBook.get(fileName).writeContactCsv(basePath + "/" + fileName + ".csv");
	}


	/**
	 * Method to read from the csv file
	 */
	private static void readFromCsv() {
		String basePath = "/Users/anirudhasm/Desktop/eclipse-yml_training_workspace/AddressBookSystem/csvresource";
		System.out.println("Enter the address book you wanna read");
		String filename = sc.next();
		File file = new File(basePath + "/" + filename + ".csv");
		if (!file.exists()) {
			System.out.println("Address book not found");
			return;
		}
		AddressBook adBook = new AddressBook(filename);
		addressBook.put(filename, adBook);
		adBook.addContactCsv(basePath + "/" + filename + ".csv");
	}


	/**
	 * Method to write into file
	 */
	private static void writeToFile() {
		String basePath = "/Users/anirudhasm/Desktop/eclipse-yml_training_workspace/AddressBookSystem/data";
		System.out.println("Enter the address book you wanna write");
		String fileName = sc.next();
		AddressBook Book = addressBook.get(fileName);
		if (Book == null) {
			System.out.println("No book found");
			return;
		}
		addressBook.get(fileName).writeContact(basePath + "/" + fileName);
	}


	/**
	 * Method to read from the file
	 */
	private static void readFile() {
		String basePath = "/Users/anirudhasm/Desktop/eclipse-yml_training_workspace/AddressBookSystem/data";
		System.out.println("Enter the address book you wanna read");
		String filename = sc.next();
		File file = new File(basePath + "/" + filename);
		if (!file.exists()) {
			System.out.println("Address book not found");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			AddressBook adBook = new AddressBook(filename);
			addressBook.put(filename, adBook);
			adBook.addContactFile(br);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Method sorts the addressbook by place
	 */
	private static void sortByPlace() {
		System.out.println("How do you wanna sort\n1:By Zip code\n2: By City name\n3: By State name");
		Scanner m = new Scanner(System.in);
		int ch = m.nextInt();
		switch(ch) {
		case 1:
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				obj.sortZip();
			}
			break;
		case 2:
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				obj.sortCity();
			}
			break;
		case 3:
			for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
				AddressBook obj = entry.getValue();
				obj.sortState();
			}
			break;
		}		
	}


	/**
	 * Methos sorts the addressbook by name
	 */
	private static void sortByName() {
		for (Map.Entry<String, AddressBook> entry : addressBook.entrySet()) {
			AddressBook obj = entry.getValue();
			obj.sort();
		}
	}


	/**
	 * Method adds the address book
	 */
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
	 * Search method to search place
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
