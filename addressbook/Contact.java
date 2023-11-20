package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Contact{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;
    private String email;

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
    public int getZip() {
        return zip;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public String toString(){
        return "First Name: " + getFirstName() +'\n'+ "Last  Name: " + getLastName() +'\n'+ "Address : "+getAddress()+ "City : " + getCity() +'\n'+ "State : " + getState()+'\n'
                + "Zip : " + getZip() +'\n'+"Phone Number : " + getPhoneNumber() +'\n'+ "Email Id: " + getEmail() ;
    }
    Scanner s=new Scanner(System.in);
    public void addContact(ArrayList<Contact> list) {
        Contact P1=new Contact();

        System.out.print("Enter First Name: ");
        P1.setFirstName(s.nextLine());
        System.out.print("Enter Last Name : ");
        P1.setLastName(s.nextLine());
        System.out.print("Enter your address :");
        P1.setAddress(s.nextLine());
        System.out.print("Enter City : ");
        P1.setCity(s.nextLine());
        System.out.print("Enter State : ");
        P1.setState(s.nextLine());
        System.out.print("Enter zip : ");
        P1.setZip(s.nextInt());
        System.out.print("Enter Phone Number: ");
        P1.setPhoneNumber(s.nextLong());
        System.out.print("Enter Email ID : ");
        P1.setEmail(s.next());

        list.add(P1);
    }
    public void displayContacts(ArrayList<Contact> list){
        System.out.println("Contacts in Address book :");
        for(Contact contact : list){
            System.out.println("First Name: " + contact.getFirstName() +'\n'+ "Last Name: " + contact.getLastName() +'\n'+ "Address : "+contact.getAddress()+ "City : " + contact.getCity() +'\n'+ "State : " + contact.getState()+'\n'
                    + "zip : " + contact.getZip() +'\n'+"Phone Number : " + contact.getPhoneNumber() +'\n'+ "Email Id: " + contact.getEmail());
        }
    }
    public void editContacts(ArrayList<Contact> list, String firstName, String lastName) {
        boolean contactAvailable = findContact(list, firstName, lastName);
        if (contactAvailable) {
            for (Contact contact : list) {
                if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                    System.out.println("What you want to edit : ");
                    System.out.println("1. Address\n2. Phone Number\n3. City\n4. State\n5. Zip\n6. Email id");
                    int choice = s.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new address: ");
                            contact.setAddress(s.next());
                            break;
                        case 2:
                            System.out.println("Enter new phone number: ");
                            contact.setPhoneNumber(s.nextLong());
                            break;
                        case 3:
                            System.out.println("Enter new city: ");
                            contact.setCity(s.next());
                            break;
                        case 4:
                            System.out.println("Enter new state: ");
                            contact.setState(s.next());
                            break;
                        case 5:
                            System.out.println("Enter Zip : ");
                            contact.setZip(s.nextInt());
                        case 6:
                            System.out.println("Enter email-id");
                            contact.setEmail(s.next());
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    System.out.println("Contact updated successfully.");
                }
            }
        } else {
            System.out.println("Contact not found.");
        }
    }
    private boolean findContact(ArrayList<Contact> list, String firstName, String lastName){
        for (Contact contact : list) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
                return true;
        }
        return false;
    }
    public void deleteContact(ArrayList<Contact> list, String firstName, String lastName) {
        Iterator<Contact> iterator = list.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
