package com.revature.services;

import com.revature.models.Account;
import com.revature.util.GenericLinkedList;
import com.revature.util.ResourceNotFoundException;

public interface Accountservices {

     /*
    Sometimes your actual goal at some point in your application
    will be to perform something as basic as just a CRUD operations.
    However, what we want to avoid is entangling the various layers of our application.
    And we want to maintain order in the control flow of execution.
    Thereby, if we need to perform a simple CRUD operation we shouldn't
    skip layers, such as the Service Layer, but instead, trivially, pass through it.
     */

    //You may opt for having some Trivial Service Methods:
    public Account addAccount(Account m);
    public Account getAccount(int id);
    public GenericLinkedList<Account> getAllAccounts();
    public Account updateAccount(Account change);
    public Account deleteAccount(int id) throws ResourceNotFoundException;

    //But you are also likely to have more Complex operations such as a need to filter, sort, or validate
    //information received from your Repositories.

//    **** This is where you would put in your log-in method ****
//             listen video 1/13 5:11 pm

    public GenericLinkedList<Account> getAccountsAboveBalance(double balance);
    public GenericLinkedList<Account> getAvailableAccounts();
    public Account checkout(Account acc);
    public boolean checkin(Account acc);

}
