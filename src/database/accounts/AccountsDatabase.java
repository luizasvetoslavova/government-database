package database.accounts;

import acc.*;
import database.operations.FileEditor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountsDatabase {

    private static AccountsDatabase instance;

    private Set<Account> accounts;

    private Set<Admin> admins;
    private Set<Organisation> organisations;
    private Set<User> users;

    private final FileEditor fileEditor;

    private final Path adminsFile;
    private final Path organisationsFile;
    private final Path usersFile;

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

        fileEditor = FileEditor.getInstance();

        adminsFile = Path.of("src", "database", "accounts", "Admins.csv");
        organisationsFile = Path.of("src", "database", "accounts", "Organisations.csv");
        usersFile = Path.of("src", "database", "accounts", "Users.csv");
    }

    public void add(Account account) {
        accounts.add(account);

        if (account instanceof Admin) {
            admins.add((Admin) account);
            fileEditor.inputData(adminsFile, account.toString());

        } else if (account instanceof Organisation) {
            organisations.add((Organisation) account);
            fileEditor.inputData(organisationsFile, account.toString());

        } else {
            if (account instanceof Bank) {
                users.add((Bank) account);
                fileEditor.inputData(usersFile, ((Bank) account).accountInfoToString());
            } else {
                // TODO instanceof police
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