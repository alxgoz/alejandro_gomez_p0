package com.revature.app;

import com.revature.models.Account;
import com.revature.util.FileDB;

import java.io.IOException;

public class FileIOTest {

    public static void main(String[] args) throws IOException {

        // Run startup to populate list
       FileDB.startUp();

       System.out.println(FileDB.accountList);

        // Run app - Create Account object
        Account acc = new Account(1,"Chris", "Ronald", 100.00, true, "87654321" );

        // Add file to Data Base
        // by putting 1 account object to GLL, then reading from it, then writing to file/DB
        FileDB.accountList.add(acc);
        FileDB.accountList.add(acc);

//        System.out.println(FileDB.accountList);
        // Run shutdown to write the list to our file
        FileDB.shutDown();




    }

}
