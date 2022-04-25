package accounts.bases;

import citizenData.lists.UserPrivacyStatus;
import fileOperations.FileEditor;

public abstract class Account extends Record {

    private static final String fileName = "accounts.database";

    private final String email;
    private final String password;

    public Account(String email, String password) {
        //account's ID's its email because it can't be used more than once
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
