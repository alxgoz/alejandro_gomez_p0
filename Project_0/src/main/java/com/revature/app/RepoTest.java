package com.revature.app;

import com.revature.models.Account;
import com.revature.repositories.AccounRepoFileImpl;
import com.revature.repositories.AccountRepo;
import com.revature.util.FileDB;

import java.io.IOException;
import java.sql.SQLOutput;

public class RepoTest {

    public static void main(String[] args) throws IOException {

        // Declared by its Interface (AccountRepo)
        // Instantiated with whatever current implementation we are developing,
        // In this case it's AccountRepoFileImpl
        AccountRepo accRepo = new AccounRepoFileImpl();

//        accRepo.addAccount(new Account( 2, "Don", "Flick", 75.00, true, "12344321"));

        System.out.println(accRepo.getAccount(2));
        System.out.println(accRepo.getAllAccounts());


        // Shutdown to save/write-out changes
        FileDB.shutDown();

    }

}
