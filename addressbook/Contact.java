package com.addressbook;

import java.util.ArrayList;
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
                + "zip : " + getZip() +'\n'+"Phone Number : " + getPhoneNumber() +'\n'+ "Email Id: " + getEmail() ;
    }
    public void Add_Contact() {

        ArrayList<Contact> list=new ArrayList<Contact>();
        Contact P1=new Contact();

        Scanner s=new Scanner(System.in);
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
        System.out.println(list);
    }
}
