package com.addressbook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBook {
	String addressBookName;
	static Scanner sc = new Scanner(System.in);

	AddressBook(String addressBookName){
		this.addressBookName=addressBookName;
	}

	static Map<String,Contact> addressBook = new HashMap<>();


	public void addContact() {
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
		String name=first_name + " "+last_name;
		Contact c = addressBook.get(name);
		if(c != null) {
			System.out.println("There is already a person with this name ");
		}
		else {
			addressBook.put(first_name+" "+last_name, contact);
		}
	}

	public void editContactPerson() {
		System.out.println("enter the first name");
		String fname = sc.nextLine();
		System.out.println("enter the last name");
		String lname = sc.nextLine();

		String name = fname + " "+lname;

		Contact personedit = addressBook.get(name);
		if(personedit == null) {
			System.out.println("Person of that name does not exit in this book");
		}
		else {
			int choice;
			while(true) {
				System.out.println("Select the field you want to edit!\n1) First Name\n2) Lastname\n"
						+ "3) Address\n4) City\n5) State\n6) Zip code\n7) Phone number\n8) Email\n"
						+ "9) Exit");
				choice = sc.nextInt();
				switch(choice) {
				case 1: 
					System.out.println("First Name:");
					String first_name=sc.next();
					personedit.first_name=first_name;
					break;
				case 2:
					System.out.println("Last Name:");
					String last_name=sc.next();
					personedit.last_name=last_name;
					break;
				case 3:
					System.out.println("Address:");
					String address=sc.next();
					personedit.address=address;
					break;
				case 4:
					System.out.println("City:");
					String city=sc.next();
					personedit.city=city;
					break;
				case 5:
					System.out.println("State:");
					String state=sc.next();
					personedit.state=state;
					break;
				case 6:
					System.out.println("zip code:");
					String zip=sc.next();
					personedit.zip=zip;
					break;
				case 7:
					System.out.println("Phone number:");
					String phone_number=sc.next();
					personedit.phone_number=phone_number;
					break;
				case 8:
					System.out.println("E-mail:");
					String email=sc.next();
					personedit.email=email;
					break;
				case 9:
					return;
				}
			}
		}
	}

	public void deleteContactPerson() {
		
		System.out.println("Enter First name of the contact to be deleted");
		String first_name = sc.next();
		
		System.out.println("Enter Last name of the contact to be deleted");
		String last_name = sc.next();
		
		String name = first_name + " "+last_name;
		Contact c = addressBook.get(name);
		if(c == null) {
			System.out.println("Person of that name does not exist in this book");

		}
		else {
			addressBook.remove(name);
			System.out.println("Contact Deleted!!");
		}
	}

	public void print() {
		for(Contact c:addressBook.values()) {
			System.out.println(c);
		}
	}

}
