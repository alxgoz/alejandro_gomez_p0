package com.revature.repositories;

import com.revature.models.Account;
import com.revature.util.GenericLinkedList;
import com.revature.util.JDBCConnection;
import com.revature.util.ResourceNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepoDBImpl implements AccountRepo{

    Connection conn = JDBCConnection.getConnection();

    @Override
    public Account addAccount(Account acc) {
        return null;
    }

    // Returns null if no account is found with that id
    @Override
    public Account getAccount(int id) {
        // Make a String for the SQL statement you want executed. Use placeholders for data values
        String sql = "SELECT * FROM account WHERE m_id = ?";

        try {
            // Set up PreparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            // Set values for any Placeholders (ie ?)
            ps.setInt(1, id);

            // Execute query, store results -> ResultSet
            ResultSet rs = ps.executeQuery();

            // Extract results out of ResultSet
            if(rs.next()){
                return buildAccount(rs);
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
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

    //  Helper Method
    private Account buildAccount(ResultSet rs) throws SQLException {
        Account acc = new Account();
        acc.setId(rs.getInt("m_id"));
        acc.setFName(rs.getString("fName"));
        acc.setLName(rs.getString("lName"));
        acc.setBalance(rs.getDouble("balance"));
        acc.setAvailable(rs.getBoolean("available"));
        acc.setPw(rs.getString("pw"));
        return acc;
    }
}
