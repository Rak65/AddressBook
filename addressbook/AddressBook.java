package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> list=new ArrayList<>();
    public void operate() {
        int choice;
        boolean isValid = true;
        while (isValid) {
            Contact contact = new Contact();
            System.out.println("Choose your option : ");
            System.out.println("1. Add Contact");
            System.out.println("2. Display all contact");
            System.out.println("3. Edit contact");
            System.out.println("4. Delete contact.");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    contact.addContact(list);
                    break;
                case 2:
                    contact.displayContacts(list);
                    break;
                case 3:
                    System.out.println("Search contact which you want to edit :");
                    System.out.println("Enter firstname : ");
                    String firstName = scanner.next();
                    System.out.println("Enter lastname : ");
                    String lastNAme = scanner.next();
                    contact.editContacts(list, firstName, lastNAme);
                    break;
                case 4:
                    System.out.println("Enter firstname to delete: ");
                    String deleteFirstName = scanner.next();
                    System.out.println("Enter lastname to delete: ");
                    String deleteLastName = scanner.next();
                    contact.deleteContact(list, deleteFirstName, deleteLastName);
                    break;
                case 5:
                    isValid = false;
                    break;
                default:
                    System.out.println("Enter valid option.");
                    break;
            }
        }
    }
}
