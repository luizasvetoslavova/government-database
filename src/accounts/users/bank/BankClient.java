package accounts.users.bank;

import citizenData.elements.Citizen;
import fileOperations.FileEditor;

public class BankClient extends Citizen {

    private Bank bank;
    private double balance;
    private double debt;

    private String phoneNumber;
    private String email;

    public BankClient(String name, String id, String address, Bank bank) {
        super(name, id, address);
        this.bank = bank;
        FileEditor.getInstance().inputObject(this.bank.getBankDatabaseName(), this);
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
