/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingapplication3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class BankingApplication3 {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        int option = 0;

        // creater account
        Account account;
        // Account field
        String name;
        int number;
        double balance;
        String accountType = "";
        double minimum = 1000;
        //create bank 
        Bank bank = new Bank("mybank");

        while (option != 6) {
            menu();
            option = scaner.nextInt();
            scaner.nextLine();

            switch (option) {
                case 1: {
                    bank.listAccount();
                    break;
                }
                case 2: {
                    int accountNum = gennerateAccountNumber();
                    System.out.println("Input detail about your account");
                    System.out.print("Enter Account name : ");
                    name = scaner.nextLine();
                    //System.out.print("Enter Account number : ");
                    //number = scaner.nextInt();
                    System.out.print("Enter initial balance : ");

                    balance = scaner.nextDouble();
                    scaner.nextLine();

                    System.out.print("Enter account type(s/c): ");

                    accountType = scaner.nextLine().toLowerCase();

                    if (accountType.equals("s")) {
                        account = new SavingAccount(accountNum, name, balance);
                    } else {
                        account = new CurrentAccount(accountNum, name, balance);
                    }

                    bank.openAccount(account);
                    break;
                }
                case 3: {
                    System.out.print("Enter Account number you want to closed : ");
                    number = scaner.nextInt();
                    scaner.nextLine();
                    System.out.print("Enter account type(s/c): ");
                    accountType = scaner.nextLine().toLowerCase();
                    if (accountType.equals("s")) {
                        account = bank.getAccount(number, "SavingAccount");
                    } else {
                        account = bank.getAccount(number, "CurrentAccount");
                    }
                    bank.closeAccount(account);
                    System.out.println("Account hava been deleted");
                    break;
                }
                case 4: {
                    System.out.print("Enter Account number : ");
                    number = scaner.nextInt();
                    scaner.nextLine();
                    System.out.print("Enter account type(s/c): ");
                    String input = scaner.nextLine().toLowerCase();
                    if (input.equals("s")) {
                        accountType = "SavingAccount";
                    } else if (input.equals("c")) {
                        accountType = "CurrentAccount";
                    }
                    System.out.print("Enter a balance to deposit : ");
                    balance = scaner.nextDouble();
                    account = bank.getAccount(number, accountType);
                    bank.depositMoney(account, balance);
                    System.out.println("Sucees your  balance is : " + account.getBalance());
                    
                    break;
                }
                case 5: {
                    System.out.print("Enter Account number : ");
                    number = scaner.nextInt();
                    scaner.nextLine();
                    System.out.print("Enter account type(s/c): ");
                    String input = scaner.nextLine().toLowerCase();
                    if (input.equals("s")) {
                        accountType = "SavingAccount";
                    } else if (input.equals("c")) {
                        accountType = "CurrentAccount";
                    }
                    System.out.print("Enter a balance to withdraw : ");
                    balance = scaner.nextDouble();
                    account = bank.getAccount(number , accountType);
                    bank.withdrawMoney(account, balance);
                    System.out.println("Sucees your  balance is : " + account.getBalance());
                    break;
                }
                case 6: {
                    break;
                }
                default: {
                    System.out.println("Please input a following number");
                }
            }
        }
    }

    public static void menu() {
        System.out.println("1. Display All Accounts​");
        System.out.println("2. Open New Account​");
        System.out.println("3. Close Existing Account");
        System.out.println("4. Deposit​");
        System.out.println("5. Withdraw​");
        System.out.println("6. Exit");
        System.out.print("Enter your choices :");
    }

    public static int gennerateAccountNumber() {
        Random ran = new Random();
        int accNum = 100000 + ran.nextInt(900000);
        return accNum;

    }
}
