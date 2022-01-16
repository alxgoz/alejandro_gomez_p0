package com.revature.app;

import com.revature.models.Account;
import com.revature.util.GenericLinkedList;

public class ModelTest {

    public static void main(String[] args) {

        Account acc = new Account();

        acc.setId(1);
        acc.setFName("John");
        acc.setLName("Ronald");
        acc.setBalance(5.00);
        acc.setAvailable(true);
        acc.setPw("12345678");

        System.out.println(acc);
        System.out.println(acc.getPw());

        GenericLinkedList<Account> accountList = new GenericLinkedList<>();

        accountList.add(acc);
        accountList.add(acc);

        System.out.println(accountList);

    }
}
