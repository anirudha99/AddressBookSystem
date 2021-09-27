package com.addressbook;

import java.util.Collection;


import java.util.HashMap;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBook {
	String addressBookName;

	static Scanner sc = new Scanner(System.in);

	Map<String, Contact> contacts;


	AddressBook(String addressBookName){
		this.addressBookName = addressBookName;
		this.contacts = new HashMap<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressBookName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBook other = (AddressBook) obj;
		return Objects.equals(addressBookName, other.addressBookName);
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	/**
	 * add contact to address book
	 */
	public void addContact() {
		Contact contact;
		System.out.println("Enter the Contact Details");
		System.out.println("Enter the first name");
		String first_name = sc.nextLine();

		System.out.println("Enter the last name");
		String last_name = sc.nextLine();

		System.out.println("Enter the address");
		String address = sc.nextLine();

		System.out.println("Enter the city");
		String city = sc.nextLine();

		System.out.println("Enter the state");
		String state = sc.nextLine();

		System.out.println("Enter the zip code");
		String zip = sc.nextLine();

		System.out.println("Enter the phone Number");
		String phone_number = sc.nextLine();

		System.out.println("Enter the email Id ");
		String email = sc.nextLine();

		contact = new Contact(first_name,last_name,address,city,state,zip,phone_number,email);
		String name=first_name + " "+ last_name;

		Set<String> keyset = contacts.keySet();
		Supplier<Stream<String>> streamSupplier = () -> keyset.stream();
		Optional<String> result1 = streamSupplier.get().findAny();
		if (result1.isEmpty()) {
			System.out.println("Adding details");
			contacts.put(first_name + " " + last_name, contact);
		} 
		else {
			if (streamSupplier.get().anyMatch(x -> x.equals(name))) {
				System.out.println("There is already a person with this name ");
			} else {
				System.out.println("Adding details");
				contacts.put(first_name + " " + last_name, contact);
			}
		}
	}

	/**
	 * edit contact in address book
	 */
	public void editContactPerson() {
		System.out.println("enter the first name");
		String fname = sc.nextLine();
		System.out.println("enter the last name");
		String lname = sc.nextLine();

		String name = fname + " "+lname;

		Contact personedit = contacts.get(name);
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
					String first_name = sc.next();
					personedit.first_name = first_name;
					break;
				case 2:
					System.out.println("Last Name:");
					String last_name = sc.next();
					personedit.last_name = last_name;
					break;
				case 3:
					System.out.println("Address:");
					String address = sc.next();
					personedit.address = address;
					break;
				case 4:
					System.out.println("City:");
					String city = sc.next();
					personedit.city = city;
					break;
				case 5:
					System.out.println("State:");
					String state = sc.next();
					personedit.state = state;
					break;
				case 6:
					System.out.println("zip code:");
					String zip = sc.next();
					personedit.zip = zip;
					break;
				case 7:
					System.out.println("Phone number:");
					String phone_number = sc.next();
					personedit.phone_number = phone_number;
					break;
				case 8:
					System.out.println("E-mail:");
					String email = sc.next();
					personedit.email = email;
					break;
				case 9:
					return;
				}
			}
		}
	}

	/**
	 * delete contact
	 */
	public void deleteContactPerson() {

		System.out.println("Enter First name of the contact to be deleted");
		String first_name = sc.next();

		System.out.println("Enter Last name of the contact to be deleted");
		String last_name = sc.next();

		String name = first_name + " "+last_name;
		Contact c = contacts.get(name);
		if(c == null) {
			System.out.println("Person of that name does not exist in this book");

		}
		else {
			contacts.remove(name);
			System.out.println("Contact Deleted!!");
		}
	}

	/**
	 * print contact
	 */
	public void print() {
		for (Map.Entry<String, Contact> entry : contacts.entrySet())
			System.out.println(entry.getValue());
	}

	/**
	 * @param place
	 * method to search by the place in city
	 */
	public int searchCity(String place) {

		Map<String, Contact> cityMap = new HashMap<>();

		Set<Map.Entry<String, Contact>> entries = contacts.entrySet();
		Stream<Map.Entry<String, Contact>> entriesStream = entries.stream();

		Set<String> keySet = contacts.keySet();
		Collection<Contact> values = contacts.values();

		Stream<Contact> valuesStream = values.stream();
		Stream<String> keysStream = keySet.stream();

		valuesStream.anyMatch((x) -> {
			if (x.city.equals(place)) {
				cityMap.put(x.city, x);
				return true;
			} 
			else {
				return false;
			}
		});

		for (Map.Entry<String, Contact> entry : cityMap.entrySet())
			System.out.println(entry.getValue());

		return cityMap.size();
	}

	/**
	 * @param place
	 * @return the number of contacts present in that state
	 */
	public int searchState(String place) {

		Map<String, Contact> statesMap = new HashMap<>();

		Set<Map.Entry<String, Contact>> entries = contacts.entrySet();
		Stream<Map.Entry<String, Contact>> entriesStream = entries.stream();

		Set<String> keySet = contacts.keySet();
		Collection<Contact> values = contacts.values();

		Stream<Contact> valuesStream = values.stream();
		Stream<String> keysStream = keySet.stream();

		valuesStream.anyMatch((x) -> {
			if (x.state.equals(place)) {
				statesMap.put(x.state, x);
				return true;
			} 
			else {
				return false;
			}
		});

		for (Map.Entry<String, Contact> entry : statesMap.entrySet())
			System.out.println(entry.getValue());

		return statesMap.size();
	}

	/**
	 * Method to sort names
	 */
	public void sort() {

		Map<String, Contact> sortedContact = contacts.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		for (Map.Entry<String, Contact> entry : sortedContact.entrySet()) {

			System.out.println(entry.getValue());
		}
		System.out.println("-------------------------------------------------------------");
	}

	/**
	 * Method to sort zip codes
	 */
	public void sortZip() {
		Set<Map.Entry<String, Contact>> entries = contacts.entrySet();
		Stream<Map.Entry<String, Contact>> entriesStream = entries.stream();

		Set<String> keySet = contacts.keySet();
		Collection<Contact> values = contacts.values();

		Stream<Contact> valuesStream = values.stream();
		Stream<String> keysStream = keySet.stream();

		valuesStream.sorted((p1, p2) -> p1.zip.compareTo(p2.zip)).forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");
	}

	/**
	 * Method to sort city names
	 */
	public void sortCity() {
		Set<Map.Entry<String, Contact>> entries = contacts.entrySet();
		Stream<Map.Entry<String, Contact>> entriesStream = entries.stream();

		Set<String> keySet = contacts.keySet();
		Collection<Contact> values = contacts.values();

		Stream<Contact> valuesStream = values.stream();
		Stream<String> keysStream = keySet.stream();

		valuesStream.sorted((p1, p2) -> p1.city.compareTo(p2.city)).forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");
	}

	/**
	 * Method to sort state names
	 */
	public void sortState() {
		Set<Map.Entry<String, Contact>> entries = contacts.entrySet();
		Stream<Map.Entry<String, Contact>> entriesStream = entries.stream();

		Set<String> keySet = contacts.keySet();
		Collection<Contact> values = contacts.values();

		Stream<Contact> valuesStream = values.stream();
		Stream<String> keysStream = keySet.stream();

		valuesStream.sorted((p1, p2) -> p1.state.compareTo(p2.state)).forEach(System.out::println);
		System.out.println("-------------------------------------------------------------");
	}

	/**
	 * Method to read the file
	 * @param br
	 */
	public void addContactFile(BufferedReader br) {
		Contact contact;
		String row;

		try {
			while((row = br.readLine()) != null) {
				String [] data = row.split(",");
				contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
				String name = data[0] + " " + data[1];
				Contact c = contacts.get(name);

				if (c == null) {
					contacts.put(name, contact);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to write the contact into the file
	 * @param fileName
	 */
	public void writeContact(String fileName) {
		try {
			BufferedWriter f_writer = new BufferedWriter(new FileWriter(fileName, false));
			for (Contact c : contacts.values()) {
				f_writer.write(String.join(",", c.first_name, c.last_name, c.address, c.city, c.state, c.zip,
						c.phone_number, c.email));
				f_writer.write("\n");
			}
			f_writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reads file of csv type and adds contact
	 * @param file
	 */
	public void addContactCsv(String file) {
		FileReader filereader;
		try {
			// Create an object of filereader class
			// with CSV file as a parameter.
			filereader = new FileReader(file);
			// create csvReader object
			// and skip first Line
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();
			Contact contact;
			// print Data
			for (String[] row : allData) {
				contact = new Contact(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
				String name = row[0] + " " + row[1];
				Contact c = contacts.get(name);

				if (c == null) {
					contacts.put(name, contact);
				}
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writeContactCsv(String filePath) {
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile, ',', CSVWriter.NO_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			// adding header to csv
			String[] header = { "FistName", "Lastname", "Address", "City", "State", "Zip", "Phone Number", "Email" };
			writer.writeNext(header);

			for (Contact c : contacts.values()) {
				String[] data1 = { c.first_name, c.last_name, c.address, c.city, c.state, c.zip, c.phone_number, c.email};
				writer.writeNext(data1);
			}

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}


