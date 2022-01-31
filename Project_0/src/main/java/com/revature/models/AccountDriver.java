package com.revature.models;

import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoDBImpl;
import org.omg.Messaging.SyncScopeHelper;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class AccountDriver {

    public static void main(String[] args) {

        // START HERE!!!
        StartProject_0();

    }

    public static void accountMenu(AccountRepo ar, int id){
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do:");
        System.out.println("Option 1: Check balance");
        System.out.println("Option 2: Deposit");
        System.out.println("Option 3: Withdraw");
        System.out.println("Option 0: Exit");
        System.out.println("Enter option: ");
        int option = scan.nextInt();
        scan.nextLine();

        if (option < 0 || option > 3){
            System.out.println("The entry " + option + " is not one of the options.");
            System.out.println("Please enter a value between 0 - 2 only.\n");
            accountMenu(ar, id);
        }

        switch (option) {
            // Check balance
            case 1:
                System.out.println("You selected Option 1:");
                NumberFormat formatter = NumberFormat.getCurrencyInstance();


                Account a = ar.getAccount(id);
                Double localBalance =  a.getBalance();
                System.out.println("Your balance is: " +formatter.format(localBalance) + "\n");

                accountMenu(ar,id);
                break;
            // Make Deposit
            case 2:
                System.out.println("You selected Option 2:");
                System.out.println("Type the amount you would like to deposit ");

                Double deposit = scan.nextDouble();

                while(deposit <= 0){
                    System.out.println("That is not a valid entry.  Try again!");
                    deposit = scan.nextDouble();
                }

                    // Add deposit to current balance
                    Account acc = ar.getAccount(id);
                    acc.setBalance(deposit + acc.getBalance());
                    Account account =  ar.updateAccount(acc);
                NumberFormat formatterW = NumberFormat.getCurrencyInstance();
                System.out.println("\nhis is your new balance " + formatterW.format(account.getBalance()));

//                NumberFormat formatter2 = NumberFormat.getCurrencyInstance();
//                System.out.println(formatter2.format(deposit));

               accountMenu(ar, id);
                break;
             // Withdraw
            case 3:
                 formatterW = NumberFormat.getCurrencyInstance();
                System.out.println("You selected Option 3: ");
                System.out.println("Type the amount you would like to withdraw ");
                // scan = new Scanner(System.in);
                Double withdrawAmount = scan.nextDouble();

                while(withdrawAmount <= 0){
                    System.out.println("That is not a valid entry.  Try again!");
                    withdrawAmount = scan.nextDouble();
                }

            // Check that withdraw amount is not greater than balance
                Account accountToWithdrawFrom = ar.getAccount(id);
                 if( accountToWithdrawFrom.getBalance() >= withdrawAmount ){
                     accountToWithdrawFrom.setBalance( accountToWithdrawFrom.getBalance() - withdrawAmount);
                     ar.updateAccount(accountToWithdrawFrom);
                     System.out.println("Your withdrawal has been successful");
                     System.out.println("New Balance :" + formatterW.format(accountToWithdrawFrom.getBalance()));
                     accountMenu(ar, id);
                 }else{
                     System.out.println("\nYou do not have enough funds to complete this transaction");
                     System.out.println("Check your balance and try again\n");
                     accountMenu(ar, id);
                 }

                break;
            // exit system
            case 0:
                System.out.println("You selected to exit Account Menu.\n");
                System.out.println("Main Menu");
                StartProject_0();
                break ;
        }
        scan.close();

    }

    public static void login(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your ID number: ");
        String stringID =  scan.nextLine();
        int intID = Integer.parseInt(stringID);
        System.out.println("Enter your password: ");

        String userPW = scan.nextLine();

//        System.out.println("ID: " + intID + "  Password: " + userPW);

//       get Account from DB when given ID by user
        AccountRepo ar = new AccountRepoDBImpl();
        Account a = ar.getAccount(intID);
        String dbPW =  a.getPw();
//       Compare password retrieved from DB to the password given by the user



        if ( dbPW.equals(userPW) ){
            System.out.println("\nYou are now logged in to your account\n");
//             If the passwords match, call the account menu and send the instance of account repo with id
             accountMenu(ar,intID);
        }else {
            System.out.println(" \n\nThe passwords do not match! " );
            System.out.println("          Good bye!          \n\n" );
            StartProject_0();
        }

//        scan.close();
    }

    public static void createAccount(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.println("Hello, " + firstName + " " + lastName + "! Now enter a 4 digit password.");

        //System.out.println("\nNow enter a 4 digit password...");
        String tempPW = scan.nextLine();

        while (tempPW.length() != 4){
            System.out.println(tempPW + " is not 4 characters.  Try again.");
            System.out.println("Enter 4 characters only: ");
             tempPW = scan.nextLine();
        }


        AccountRepo ar = new AccountRepoDBImpl();
        Account a = ar.addAccount(new Account( firstName, lastName, 0.0, true, tempPW));
        System.out.println("\nSuccess!  Your Account has been created, " + firstName + " " + lastName + "!");

        System.out.println("Make sure to secure your ID: '" + a.getId() + "' You will need it to log back in. Good Bye!");

        System.out.print("\n");
        //System.out.println(ar.getAccount(a.getId()));
        System.out.println("==============================================");

        StartProject_0();

    }

    public static void StartProject_0()      {
          Scanner scan = new Scanner(System.in);
        System.out.println(" *** Welcome to Simple Bank ***");
        System.out.println("\nEnter the number matching the action you want to take:\n");
        System.out.println("Option 1: Log in to Account");
        System.out.println("Option 2: Create Account");
        System.out.println("Option 0: Exit\n");
        System.out.println("Enter option: ");
        try {
            int option = scan.nextInt();

            //scan.nextLine();
            if (option < 0 || option > 2) {
                System.out.println("The entry " + option + " is not one of the options.");
                System.out.println("Please enter a value between 0 - 2 only.\n");
                StartProject_0();
            }
            switch (option) {
                // Login
                case 1:
                    System.out.println("You selected Option 1:\nLog in to account manager\n");
                    login();
                    break;
                // create  account
                case 2:
                    System.out.println("You selected Option 2, Create account.");
                    createAccount();
                    break;
                // exit system
                case 0:
                    System.out.println("You selected Exit");
                    System.out.println("Good Bye!");
                    break;
            }
            scan.close();
        }catch (Exception e){
            System.out.println("That is NOT a Valid Input.  Good bye!\n");
            StartProject_0();
        }
    }
}
