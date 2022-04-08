package acc;

import database.accounts.AccountsDatabase;
import database.operations.FileEditor;

import java.nio.file.Path;

public abstract class Account {

    private final String email;
    private final String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;

        FileEditor fileEditor = FileEditor.getInstance();

        Path adminsFile = Path.of("src", "database", "accounts", "Admins.csv");
        Path organisationsFile = Path.of("src", "database", "accounts", "Organisations.csv");
        Path usersFile = Path.of("src", "database", "accounts", "Users.csv");

        if(this instanceof Admin) {
            fileEditor.inputData(adminsFile, this.toString());

        } else if (this instanceof Organisation) {
            fileEditor.inputData(organisationsFile, this.toString());

        } else {
            fileEditor.inputData(usersFile, this.toString());
        }

        AccountsDatabase.getInstance().add(this);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
