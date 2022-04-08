package database;

import accounts.bases.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountsDatabase extends Database<Account> {

    private static AccountsDatabase instance;

    private Set<Account> accounts;

    public static AccountsDatabase getInstance() {
        if (instance == null) {
            instance = new AccountsDatabase();
        }
        return instance;
    }

    private AccountsDatabase() {
        accounts = new HashSet<>();
    }

    @Override
    public String getFileName() {
        return "accounts.database";
    }

    @Override
    public Set<Account> getDatabase() {
        return accounts;
    }
}