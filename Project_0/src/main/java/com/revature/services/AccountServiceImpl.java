package com.revature.services;

import com.revature.models.Account;
import com.revature.repositories.AccountRepo;
import com.revature.util.GenericLinkedList;
import com.revature.util.ResourceNotFoundException;

//    video 1/13 5:14
public class AccountServiceImpl implements Accountservices {

    private AccountRepo ar;

    // This is a process called Dependency Injection
        public AccountServiceImpl(AccountRepo ar){
    //Constructor Injection -> When the dependency need for the Class is fulfilled in a Constructor.
        this.ar = ar;
    }

    // Our Trivial Services
    // this is where I stopped...    finish coding methods
    @Override
    public Account addAccount(Account m) {
        return null;
    }

    @Override
    public Account getAccount(int id) {
        return null;
    }

    @Override
    public GenericLinkedList<Account> getAllAccounts() {
        return null;
    }

    @Override
    public Account updateAccount(Account change) {
        return null;
    }

    @Override
    public Account deleteAccount(int id) throws ResourceNotFoundException {
        return null;
    }

    // More Complex Services
    @Override
    public GenericLinkedList<Account> getAccountsAboveBalance(double balance) {
        return null;
    }

    @Override
    public GenericLinkedList<Account> getAvailableAccounts() {
        return null;
    }

    @Override
    public Account checkout(Account acc) {
        return null;
    }

    @Override
    public boolean checkin(Account acc) {
        return false;
    }
}
