package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> list=new ArrayList<>();
        int choice;
        boolean isValid = true;
        while (isValid){
            Contact contact =new Contact();
            System.out.println("Choose your option : ");
            System.out.println("1. Add Contact");
            System.out.println("2. Display all contact");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    contact.Add_Contact(list);
                    break;
                case 2 :
                    contact.DisplayContacts(list);
                    break;
                case 3 :
                    isValid = false;
                    break;
                default:
                    System.out.println("Enter valid option.");
                    break;
            }
        }
    }
}
