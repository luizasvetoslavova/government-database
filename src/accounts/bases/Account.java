package accounts.bases;

import database.AccountsDatabase;

import java.io.Serializable;

public abstract class Account extends Record implements Serializable {

    private final String email;
    private final String password;

    public Account(String email, String password) {
        //account's ID's its email because it can't be used more than once
        super(email);
        this.email = email;
        this.password = password;

        AccountsDatabase.getInstance().add(this);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
