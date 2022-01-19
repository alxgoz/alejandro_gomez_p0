package com.revature.models;

import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoDBImpl;
import org.omg.Messaging.SyncScopeHelper;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class AccountDriver {

    public static void main(String[] args) {

        StartProject_0();

    }

    public static void accountMenu(AccountRepo ar, int id){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number corresponding to your option:");
        System.out.println("Option 1: Check balance");
        System.out.println("Option 2: Deposit");
        System.out.println("Option 3: Withdraw");
        System.out.println("Option 0: Exit");
        System.out.println("Enter option: ");
        int option = scan.nextInt();
        scan.nextLine();

        switch (option) {
            // Check balance
            case 1:
                System.out.println("You selected Option 1: Check balance");
                NumberFormat formatter = NumberFormat.getCurrencyInstance();


                Account a = ar.getAccount(id);
                Double localBalance =  a.getBalance();
                System.out.println("Your balance is: " +formatter.format(localBalance) + "\n");

                accountMenu(ar,id);
                break;
            // Make Deposit
            case 2:
                System.out.println("You selected Option 2: Make a deposit");
                System.out.println("Type the amount you would like to deposit ");
               // scan = new Scanner(System.in);
                Double deposit = scan.nextDouble();

                    // Add deposit to current balance
                    Account acc = ar.getAccount(id);
                    acc.setBalance(deposit + acc.getBalance());
                    ar.updateAccount(acc);

                System.out.println("DB " + ar.getAccount(acc.getId()));

//                NumberFormat formatter2 = NumberFormat.getCurrencyInstance();
//                System.out.println(formatter2.format(deposit));

               accountMenu(ar, id);
                break;
             // Withdraw
            case 3:
                NumberFormat formatterW = NumberFormat.getCurrencyInstance();
                System.out.println("You selected Option 3: Make a withdraw");
                System.out.println("Type the amount you would like to withdraw ");
                // scan = new Scanner(System.in);
                Double withdrawAmount = scan.nextDouble();

            // Check that withdraw amount is not greater than balance
                Account accountToWithdrawFrom = ar.getAccount(id);
                 if( accountToWithdrawFrom.getBalance() >= withdrawAmount ){
                     accountToWithdrawFrom.setBalance( accountToWithdrawFrom.getBalance() - withdrawAmount);
                     ar.updateAccount(accountToWithdrawFrom);
                     System.out.println("You withdraw has been successful");
                     System.out.println("New Balance :" + formatterW.format(accountToWithdrawFrom.getBalance()));
                     accountMenu(ar, id);
                 }else{
                     System.out.println("You do not have enough funds to complete transaction");
                     System.out.println("Check your balance and try again");
                     accountMenu(ar, id);
                 }

                break;
            // exit system
            case 0:
                System.out.println("You selected Option 0: Exit Menu");
                System.out.println("Good Bye!!!");
                StartProject_0();
                break ;
        }
        scan.close();

    }

    public static void login(){

        System.out.println("Provide log-in details");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your numerical ID: ");
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
            System.out.println("You have gained access to your account");
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
        System.out.println("Hello " + firstName + " " + lastName);

        System.out.println("Enter an 1 digit password");
        String tempPW = scan.nextLine();

        while (tempPW.length() != 1){
            System.out.println("That is not 1 characters.  Try again!");
            System.out.println("Enter an 8 digit password");
             tempPW = scan.nextLine();
        }


        AccountRepo ar = new AccountRepoDBImpl();
        Account a = ar.addAccount(new Account( firstName, lastName, 0.0, true, tempPW));
        System.out.println("Your Account has been created");
        System.out.println("Make sure to secure your ID and Password to log back in.");

        System.out.print("Details of your ");
        System.out.println(ar.getAccount(a.getId()));
        System.out.println("==============================================");

        StartProject_0();




    }

    public static void StartProject_0(){
          Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number corresponding to your option:");
        System.out.println("Option 1: Log-in to account manager");
        System.out.println("Option 2: Create account");
        System.out.println("Option 0: Exit");
        System.out.println("Enter option: ");
        int option = scan.nextInt();
        scan.nextLine();

        switch (option) {
                // Login
                case 1:
                    System.out.println("You selected Option 1:\nLog-in to account manager");
                    login();
                    break;
                // create  account
                case 2:
                    System.out.println("You selected Option 2:\nCreate account");
                    createAccount();
                    break;
                // exit system
                case 0:
                    System.out.println("Option 0 to exit system");
                    System.out.println("Good Bye!!!");
                    break ;
            }
        scan.close();
    }
}
