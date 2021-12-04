package org.email.administrative.system;

import java.io.*;
import java.util.*;

public class Email {
    public Scanner sc = new Scanner(System.in);

    private String fName;
    private String lName;
    private String dept;
    private String email;
    private String passowrd;
    private int minCapacity = 500;
    private String alterEmail;

    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee: " + this.fName + " " + this.lName);

        this.dept = setDept();
        this.passowrd = generatePassword(8);
        email = generateEmail();

    }

    private String generateEmail() {
        return fName.toLowerCase() + "." + lName.toLowerCase() + "@" + dept.toLowerCase() + ".com";
    }

    private String setDept() {
        System.out.println("Department codes \n1. Sales\n2. Development\n3. Accountant");
        boolean flag = false;
        do {
            System.out.println("Enter Dept. Code");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        } while (!flag);

        return null;
    }

    //Generate Random password
    private String generatePassword(int length) {
        Random random = new Random();
        String capitalCharacters = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String smallCharacters = "qwertyuiopasdfghjklzxcvbnm";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*?";
        String values = capitalCharacters + smallCharacters + numbers + symbols;
        StringBuilder passwordBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            passwordBuilder.append(values.charAt(random.nextInt(values.length())));
        }
        return passwordBuilder.toString();
    }

    //change password method
    public void setPassword() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change the password (Y/N)");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password");
                String temp = sc.next();
                if (temp.equals(passowrd)) {
                    System.out.println("Enter new password");
                    passowrd = sc.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect Password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled");
            } else {
                System.out.println("Enter valid choice");
            }
        } while (!flag);
    }

    //set mailbox capacity
    public void setMailCap(){
        System.out.println("Current capacity "+minCapacity+" mb");
        System.out.println("Enter new capacity");
        minCapacity = sc.nextInt();
        System.out.println("Mailbox capacity changed successfully");

    }
    //set alternate mail
    public void generateAlternateEmail(){
        System.out.println("Enter new alternate email");
        alterEmail = sc.next();
        System.out.println("Alter Email added successfully");
    }

    //print user information
    public void getInfo(){
        System.out.println("New "+fName+" "+lName);
        System.out.println("Dept "+dept);
        System.out.println("Email "+email);
        System.out.println("Min Capacity "+minCapacity);
        System.out.println("Alt. email "+alterEmail);
        System.out.println("Password "+passowrd);
    }

    //store file
    public void saveFile(){
        try{
            FileWriter in = new FileWriter("//Users//milindbasavaraja//IdeaProjects//EmailAdministrativeSystem//info.txt");
            in.write("First Name: "+ fName );
            in.append("Last Name: ").append(lName);
            in.append("Department: ").append(dept);
            in.append("Email: ").append(email);
            in.append("Passowrd: ").append(passowrd);
            in.append("Alt. Email: ").append(alterEmail);
            in.append("Capacity: ").append(String.valueOf(minCapacity));
            in.close();
            System.out.println("Data Stored");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readFile(){
        try{
            FileReader fileReader = new FileReader("//Users//milindbasavaraja//IdeaProjects//EmailAdministrativeSystem//info.txt");
            int i;
            while((i=fileReader.read())!=-1){
                System.out.print((char) i);
            }
            fileReader.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }

}
