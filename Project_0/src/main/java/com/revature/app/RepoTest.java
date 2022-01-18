package com.revature.app;

import com.revature.models.Account;
import com.revature.repositories.AccounRepoFileImpl;
import com.revature.repositories.AccountRepo;
import com.revature.repositories.AccountRepoDBImpl;
import com.revature.util.FileDB;
import com.revature.util.ResourceNotFoundException;
import org.omg.Messaging.SyncScopeHelper;

import java.io.IOException;
import java.sql.SQLOutput;

public class RepoTest {

    public static void main(String[] args) throws IOException, ResourceNotFoundException {

       AccountRepo ar = new AccountRepoDBImpl();
      //Account a = ar.addAccount(new Account( "Rich", "DeLucca", 50000, true, "43211234"));

        //System.out.println(ar.getAccount(a.getId()));
        //System.out.println(ar.getAllAccounts());


        // Test addAccount
        // Declared by its Interface (AccountRepo)
        // Instantiated with whatever current implementation we are developing,
        // In this case it's AccountRepoFileImpl
        // AccountRepo accRepo = new AccounRepoFileImpl();

//
//        Test getAccount when given specific ID
//        System.out.println(accRepo.getAccount(2));
//        System.out.println(accRepo.getAllAccounts());
//        End Test getAccount
//
//        Test updateAccount by balance increasing balance by 1
//        Account acc = ar.getAccount(1);
//        acc.setBalance(acc.getBalance() + 1);
//        ar.updateAccount(acc);
//        System.out.println(acc);

//        System.out.println(accRepo.getAccount(2));
//        End Test updateAccount

//        Test deleteAccount
        System.out.println(ar.getAllAccounts());

        try {
            System.out.println( ar.deleteAccount(1));
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ar.getAllAccounts());
//        End Test deleteAccount


//        ++Shutdown to save/write-out changes++
//            FileDB.shutDown();

    }

}
