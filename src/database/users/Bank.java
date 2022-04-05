package database.users;

import acc.User;

public class Bank extends User {
    private static int banksCount;
    private int serialNumber;

    private String address;
    private String name;

    private String email;
    private String password;

    private BankDatabase bankDatabase;

    public Bank(String email, String password, String address, String name) {
        super(email, password);
        this.address = address;
        this.name = name;

        banksCount++;
        serialNumber = banksCount;

        bankDatabase = new BankDatabase(this);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public BankDatabase getDatabase() {
        return bankDatabase;
    }

    //when saving into citizen data file, use that method
    public String bankInfoToString() {
        return "Bank{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //when saving into accounts file, use that method
    public String accountInfoToString() {
        return "Bank{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}