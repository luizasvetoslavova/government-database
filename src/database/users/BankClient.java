package database.users;

import citizenData.Citizen;
import citizenData.lists.Gender;

public class BankClient extends Citizen {

    private double balance;
    private double debt;
    private String phoneNumber;
    private String email;

    public BankClient(String name, String id, String address, Gender gender) {
        super(name, id, address, gender);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankClient{" +
                "balance=" + balance +
                ", debt=" + debt +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
