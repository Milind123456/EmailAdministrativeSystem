package org.email.administrative.system;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String fName = sc.next();

        System.out.println("Enter last name");
        String lName = sc.next();

        Email email = new Email(fName,lName);
        int choice = -1;

        do{
            System.out.println("\n********************\nEnter your choice\n1. Show info\n2. Change password\n3. Change Mailbox Capacity\n4. Set Alternate Email\n5. Save\n6. Read\n7. Exit");
            choice = sc.nextInt();
            switch (choice){
                case 1: email.getInfo();
                break;
                case 2: email.setPassword();
                break;
                case 3: email.setMailCap();
                break;
                case 4: email.generateAlternateEmail();
                break;
                case 5:
                    email.saveFile();
                    break;
                case 6:
                    email.readFile();
                    break;
                case 7: System.out.println("Thank you for using our application");
                break;
                default:
                    System.out.println("Invalid option");

            }
        }while (choice!=7);
    }
}
