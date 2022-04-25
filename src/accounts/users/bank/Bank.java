package accounts.users.bank;

import accounts.bases.User;
import citizenData.lists.UserPrivacyStatus;
import fileOperations.FileEditor;

public class Bank extends User {

    private static final String fileName = "banks.database";
    private static int banksCount;
    private final int serialNumber;
    private final String bankDatabaseName = "bank" + this.getSerialNumber() + ".database";

    private final String name;
    private final String address;
    private final String email;
    private final String password;

    public Bank(String email, String password, String address, String name) {
        super(email, password);
        this.email = email;
        this.password = password;

        this.address = address;
        this.name = name;
        this.setPrivacyStatus(UserPrivacyStatus.PRIVATE);

        banksCount++;
        serialNumber = banksCount;

        FileEditor.getInstance().inputObject(fileName, this);
    }

    public String getBankDatabaseName() {
        return bankDatabaseName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}