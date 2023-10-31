package com.addressbook;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.createContact();
    }
    public void createContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name : ");
        String firstName = scanner.next();
        System.out.print("Enter your last name :");
        String lastName = scanner.next();
        System.out.print("Enter your address : ");
        String address = scanner.next();
        System.out.print("Enter your city : ");
        String city = scanner.next();
        System.out.print("Enter your state : ");
        String state = scanner.next();
        System.out.print("Enter your zip : ");
        int zip = scanner.nextInt();
        System.out.print("Enter your phone number : ");
        long phoneNumber = scanner.nextLong();
        System.out.print("Enter your maid-id : ");
        String email = scanner.next();

        System.out.println("-----------\n Your details : ");
        System.out.println("First name ---> "+firstName);
        System.out.println("Last name ---> "+lastName);
        System.out.println("Address ---> "+address);
        System.out.println("City ---> "+city);
        System.out.println("State ---> "+state);
        System.out.println("Zip ---> "+zip);
        System.out.println("Phone number ---> "+phoneNumber);
        System.out.println("E-mail ---> "+email);
    }
}
