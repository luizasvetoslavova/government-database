package accounts.users.bank;

import database.Database;

import java.util.HashSet;
import java.util.Set;

public class BankDatabase extends Database<BankClient> {

    private final Bank bank;
    private Set<BankClient> clients;

    public BankDatabase(Bank bank) {
        this.bank = bank;
        clients = new HashSet<>();
    }

    @Override
    public String getFileName() {
        return "bank" + bank.getSerialNumber() + ".database";
    }

    @Override
    public Set<BankClient> getDatabase() {
        return clients;
    }
}
