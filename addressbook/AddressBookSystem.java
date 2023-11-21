package com.addressbook;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {
    private static final Map<String, AddressBook> addressBooks = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        boolean isValid = true;

        while (isValid) {
            System.out.println("Choose your option:");
            System.out.println("1. Create new Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    selectAddressBook();
                    break;
                case 3:
                    isValid = false;
                    break;
                default:
                    System.out.println("Enter a valid option.");
                    break;
            }
        }
        scanner.close();
    }

    private static void createAddressBook() {
        System.out.println("Enter the unique name for the new Address Book:");
        String addressBookName = scanner.next();

        if (!addressBooks.containsKey(addressBookName)) {
            AddressBook addressBook = new AddressBook();
            addressBooks.put(addressBookName, addressBook);
            System.out.println("Address Book '" + addressBookName + "' created successfully.");
        } else {
            System.out.println("Address Book with the name '" + addressBookName + "' already exists.");
        }
    }

    private static void selectAddressBook() {
        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available. Please create a new Address Book first.");
            return;
        }

        System.out.println("Select an Address Book:");
        int index = 1;

        for (String addressBookName : addressBooks.keySet()) {
            System.out.println(index + ". " + addressBookName);
            index++;
        }

        int selection = scanner.nextInt();

        if (selection >= 1 && selection <= addressBooks.size()) {
            String selectedAddressBookName = getAddressBookNameAtIndex(selection);
            operateOnAddressBook(selectedAddressBookName);
        } else {
            System.out.println("Invalid selection.");
        }
    }

    private static String getAddressBookNameAtIndex(int index) {
        int i = 1;
        for (String addressBookName : addressBooks.keySet()) {
            if (i == index) {
                return addressBookName;
            }
            i++;
        }
        return null;
    }

    private static void operateOnAddressBook(String addressBookName) {
        AddressBook selectedAddressBook = addressBooks.get(addressBookName);

        if (selectedAddressBook != null) {
            selectedAddressBook.operate();
        } else {
            System.out.println("Address Book not found.");
        }
    }
}