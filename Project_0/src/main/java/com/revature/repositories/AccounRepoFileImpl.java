package com.revature.repositories;

import com.revature.models.Account;
import com.revature.util.FileDB;
import com.revature.util.GenericLinkedList;

public class AccounRepoFileImpl implements AccountRepo {

    @Override
    public Account addAccount(Account acc) {
        FileDB.accountList.add(acc);
        return acc;
    }

    @Override
    public Account getAccount(int id) {
        return FileDB.accountList.find(id);
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
    public Account deleteAccount(int id) {
        return null;
    }
}
