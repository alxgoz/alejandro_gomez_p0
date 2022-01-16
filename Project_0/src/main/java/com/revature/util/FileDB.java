package com.revature.util;

import com.revature.models.Account;

import java.io.*;

public class FileDB {

    public static GenericLinkedList<Account> accountList = new GenericLinkedList<>();
    private static final String CSV_FILE_PATH = "src/main/resources/account.csv";

    // Static block - class initializer -  executed ONCE, the first time this Class is referenced
    static {
        try {
            startUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startUp() throws IOException {

        //Set up the BufferedReader Object to the correct file path.
        // Side note: Upper snake-case for final variables
        BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH));

        // Read line from file (CSV_FILE_PATH)
        // When BufferedReader is empty the value is null
        String line = reader.readLine();
        while(line != null){

            // For each line read by the file, convert to Account object
            Account acc = parseAccount(line);

            // Add it into our Account GLL
            accountList.add(acc);

            // Read in the next line until null (which has a value of null) and breaks out of while loop
            line = reader.readLine();
        }
    reader.close();
    }

    // method reads all Account data from GLL and writes it to CSV
    public static void shutDown() throws IOException {

    // Set up the Buffered-Writer Object to the correct file path
        // Buffered-Writer reads out whole lines
        // Side note: FileWriter is meant for characters and
        // FileOutputStream is meant for writing streams of raw bytes
        BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH));

        // run loop to send out to the file
        for(int i = 0; i < accountList.getSize(); i++){

            // Convert each Account object into a String of text read for our CSV file
            // Write it into the file
            writer.write(parseCSV(accountList.get(i)));
        }
        // !!! ALWAYS CLOSE RESOURCES !!!
        // close file
        writer.close();

    }

    // Separate CSV file into tokens and input into them into correct variables of Account object
    private static Account parseAccount(String csv) {
        Account acc = new Account();
        // Regular Expression
        String[] tokens = csv.split(",");

        acc.setId(Integer.parseInt(tokens[0]));
        acc.setFName(tokens[1]);
        acc.setLName(tokens[2]);
        acc.setBalance(Double.parseDouble(tokens[3]));
        acc.setAvailable(Boolean.parseBoolean(tokens[4]));
        acc.setPw(tokens[5]);

        return acc;
    }


    // Helper method to shutDown()
    // Converts Account object into readable format and adds commas (for CSV)
    private static String parseCSV(Account acc){

        return acc.getId() + ","
                + acc.getFName() + ","
                + acc.getLName() + ","
                + acc.getBalance() + ","
                + acc.isAvailable() + ","
                + acc.getPw() + "\n";

    }


}
