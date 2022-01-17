package com.revature.repositories;

import com.revature.models.Account;
import com.revature.util.FileDB;
import com.revature.util.GenericLinkedList;
import com.revature.util.ResourceNotFoundException;

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
        return FileDB.accountList;
    }

    @Override
    public Account updateAccount(Account change) {

        Account acc = FileDB.accountList.find(change.getId());

        acc.setFName(change.getFName());
        acc.setLName(change.getLName());
        acc.setBalance(change.getBalance());
        acc.setAvailable(change.isAvailable());
        acc.setPw(change.getPw());

        return acc;
    }

    @Override
    public Account deleteAccount(int id) throws ResourceNotFoundException {

        int index = -1;
        for(int i = 0; i < FileDB.accountList.getSize(); i++) {
            if(FileDB.accountList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if(index != -1) {
            return FileDB.accountList.remove(index);
        } else {
            throw new ResourceNotFoundException("Resource not found in our data storage.");
        }



    }
}
