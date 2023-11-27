package com.addressbook;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            System.out.println("3. Search person by city or state : ");
            System.out.println("4. View person by city or state.");
            System.out.println("5. Number of contact present in city or state.");
            System.out.println("6. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAddressBook();
                    break;
                case 2:
                    selectAddressBook();
                    break;
                case 3:
                    searchPersonByCityOrState();
                    break;
                case 4:
                    searchPersonByCityOrState();
                    break;
                case 5:
                    noOfContactPerson();
                    break;
                case 6:
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
    private static void searchPersonByCityOrState() {
        System.out.println("Enter the city or state to search:");
        String searchLocation = scanner.next();

        ArrayList<Contact> searchResults = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getList().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(searchLocation)
                        || contact.getState().equalsIgnoreCase(searchLocation))
                .collect(Collectors.toCollection(ArrayList::new));

        if (searchResults.isEmpty()) {
            System.out.println("No matching contacts found in the specified city or state.");
        } else {
            System.out.println("Search Results:");
            for (Contact contact : searchResults) {
                System.out.println(contact.toString());
            }
        }
    }
    private static void noOfContactPerson() {
        System.out.println("Enter the city or state to search:");
        String searchLocation = scanner.next();

        ArrayList<Contact> searchResults = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getList().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(searchLocation)
                        || contact.getState().equalsIgnoreCase(searchLocation))
                .collect(Collectors.toCollection(ArrayList::new));
        int countContact=searchResults.size();
        System.out.println(countContact+" Person available in "+searchLocation);
    }
}