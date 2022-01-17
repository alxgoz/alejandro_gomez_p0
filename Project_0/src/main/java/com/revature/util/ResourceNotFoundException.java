package com.revature.util;

/*
    Thrown on deleteAccount method of AccountRepoFileImpl class,
     if that particular account to be deleted can not be found
 */

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}
