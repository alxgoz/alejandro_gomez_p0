package com.revature.repositories;

import com.revature.models.Account;
import com.revature.util.GenericLinkedList;

    /*
        * RESPONSIBLE FOR ANY CRUD OPERATIONS RELATED TO ACCOUNT *

       Coding to Interfaces

        - We can outline all the functionality that will be present
         in any implementation of this abstract concept.
        In other words, we can describe what we want our Account Repository to be able to do,
        and any implementation of such should achieve the same goals.
          FYI: DAO (Data Access Object) is synonymous with Repo
     */

import com.revature.models.Account;
import com.revature.util.GenericLinkedList;
import com.revature.util.ResourceNotFoundException;

public interface AccountRepo {

    // Fulfill the CRUD Operation for Account
    public Account addAccount(Account acc);
    public Account getAccount(int id);
    public GenericLinkedList<Account> getAllAccounts();
    public Account updateAccount(Account change);
    public Account deleteAccount(int id) throws ResourceNotFoundException;

}
