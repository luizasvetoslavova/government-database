package accounts.users.bank;

import accounts.bases.User;
import database.BanksDatabase;

public class Bank extends User {

    private static int banksCount;

    private final int serialNumber;
    private final String name;
    private final String address;
    private final String email;
    private final String password;

    private final BankDatabase bankDatabase;

    public Bank(String email, String password, String address, String name) {
        super(email, password);
        this.email = email;
        this.password = password;

        this.address = address;
        this.name = name;

        banksCount++;
        serialNumber = banksCount;

        BanksDatabase.getInstance().add(this);
        bankDatabase = new BankDatabase(this);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public BankDatabase getDatabase() {
        return bankDatabase;
    }
}