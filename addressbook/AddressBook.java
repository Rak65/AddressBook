package com.addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contact> list=new ArrayList<>();
    public ArrayList<Contact> getList() {
        return list;
    }
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
            System.out.println("5. Sort contacts by name.");
            System.out.println("6. Exit");
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
                    sortContactsByName();
                    break;
                case 6:
                    isValid = false;
                    break;
                default:
                    System.out.println("Enter valid option.");
                    break;
            }
        }
    }
    private void sortContactsByName() {
        if (list.isEmpty()) {
            System.out.println("No contacts to sort.");
            return;
        }

        // Sorting the list by person's name (first name + last name)
        Collections.sort(list, (contact1, contact2) -> {
            String name1 = contact1.getFirstName() + " " + contact1.getLastName();
            String name2 = contact2.getFirstName() + " " + contact2.getLastName();
            return name1.compareToIgnoreCase(name2);
        });

        System.out.println("Contacts sorted alphabetically by name.");
    }
}
