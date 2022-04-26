package accounts.bases;

import fileOperations.FileEditor;

public abstract class Account extends Record {

    private static final String fileName = "accounts.database";

    private final String email;
    private final String password;

    public Account(String email, String password) {
        super(email);
        this.email = email;
        this.password = password;
        FileEditor.getInstance().inputObject(fileName, this);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
