package com.addressbook;

public class AddressMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!");
		AddressBook addressbook = new AddressBook("John","Doe","Elite","Bantwal","Karnataka","574219","9550012911","abcd@gmail.com");
		addressbook.display();
	}

}
