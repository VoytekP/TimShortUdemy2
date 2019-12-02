package TimShort.Udemy;

import utilities.CSV;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();

        // Read and CSV File then crate new accounts based on that data
        String file = "C:\\Users\\marketing\\Desktop\\Wojtek\\JavaPrograms\\20191202NewBankAccounts.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double intDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, intDeposit));
            }
            else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, intDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account acc : accounts) {
            System.out.println("\n*************");
            acc.showInfo();
        }

    }
}
