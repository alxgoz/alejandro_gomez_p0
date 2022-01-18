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

        String sql = "INSERT INTO accounts VALUES (default,?,?,?,?,?) RETURNING *";

        try{
            PreparedStatement ps = conn.prepareStatement(sql);

            // Set values for all the placeholders: ?
            ps.setString(1, acc.getFName());
            ps.setString(2, acc.getLName());
            ps.setDouble(3, acc.getBalance());
            ps.setBoolean(4, acc.isAvailable());
            ps.setString(5, acc.getPw());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Returns null if no account is found with that id
    @Override
    public Account getAccount(int id) {
        // Make a String for the SQL statement you want executed. Use placeholders for data values
        String sql = "SELECT * FROM accounts WHERE m_id = ?";

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

        String sql = "SELECT * FROM accounts";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            //Extract all accounts out of the ResultSet
            GenericLinkedList<Account> accounts = new GenericLinkedList<Account>();
            while(rs.next()) {
                //Add each account to our list of accounts.
                accounts.add(buildAccount(rs));
            }
            return accounts;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Account updateAccount(Account change) {

        String sql = "UPDATE accounts set fname=?, lname=?, balance=?, available=?, pw=? WHERE m_id = ? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, change.getFName());
            ps.setString(2, change.getLName());
            ps.setDouble(3 , change.getBalance());
            ps.setBoolean(4, change.isAvailable());
            ps.setString(5, change.getPw());
            ps.setInt(6, change.getId());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Account deleteAccount(int id) throws ResourceNotFoundException {

        String sql = "DELETE FROM accounts WHERE m_id = ? RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return buildAccount(rs);
            }else {
                throw new ResourceNotFoundException("Resource with id: " + id + " was not found in database.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

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
