package database.accounts;

import acc.*;
import database.users.Bank;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountsDatabase {

    private static AccountsDatabase instance;

    private Set<Account> accounts;

    private Set<Admin> admins;
    private Set<Organisation> organisations;
    private Set<User> users;

    public static AccountsDatabase getInstance() {
        if (instance == null) {
            instance = new AccountsDatabase();
        }
        return instance;
    }

    private AccountsDatabase() {
        accounts = new HashSet<>();

        admins = new HashSet<>();
        organisations = new HashSet<>();
        users = new HashSet<>();
    }

    public void add(Account account) {
        accounts.add(account);

        if (account instanceof Admin) {
            admins.add((Admin) account);

        } else if (account instanceof Organisation) {
            organisations.add((Organisation) account);

        } else {
            if (account instanceof Bank) {
                users.add((Bank) account);
            } else if (account instanceof Police) {
                users.add((Police) account);
            }
        }
    }

    public Account findAccount(String email, String password) {
        return accounts
                .stream()
                .filter(account -> account.getEmail().equals(email) && account.getPassword().equals(password))
                .collect(Collectors.toList())
                .get(0);
    }

    public Set<Organisation> getOrganisations() {
        return organisations;
    }
}