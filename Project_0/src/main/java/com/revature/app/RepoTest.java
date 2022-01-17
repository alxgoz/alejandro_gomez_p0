package com.revature.app;

import com.revature.models.Account;
import com.revature.repositories.AccounRepoFileImpl;
import com.revature.repositories.AccountRepo;
import com.revature.util.FileDB;
import com.revature.util.ResourceNotFoundException;
import org.omg.Messaging.SyncScopeHelper;

import java.io.IOException;
import java.sql.SQLOutput;

public class RepoTest {

    public static void main(String[] args) throws IOException, ResourceNotFoundException {

        // Test addAccount
        // Declared by its Interface (AccountRepo)
        // Instantiated with whatever current implementation we are developing,
        // In this case it's AccountRepoFileImpl
        AccountRepo accRepo = new AccounRepoFileImpl();

      accRepo.addAccount(new Account( 2, "Rich", "DeLucca", .23, true, "43211234"));
//
//        // Test getAccount when given specific ID
//        System.out.println(accRepo.getAccount(2));
        System.out.println(accRepo.getAllAccounts());
//
//        // Test updateAccount by balance increasing balance by 1
//        Account accRepo2 = accRepo.getAccount(2);
//        accRepo2.setBalance(accRepo2.getBalance() + 1);
//
//        accRepo.updateAccount(accRepo2);
//        System.out.println(accRepo.getAccount(2));

//        accRepo.deleteAccount(1);


        // Shutdown to save/write-out changes
        FileDB.shutDown();

    }

}
