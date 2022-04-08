package database;

import accounts.users.bank.Bank;

import java.util.HashSet;
import java.util.Set;

public class BanksDatabase extends Database<Bank> {

    private static BanksDatabase instance;

    private Set<Bank> banks;

    public static BanksDatabase getInstance() {
        if(instance == null) {
            instance = new BanksDatabase();
        }
        return instance;
    }

    private BanksDatabase() {
        banks = new HashSet<>();
    }

    @Override
    public String getFileName() {
        return "banks.database";
    }

    @Override
    public Set<Bank> getDatabase() {
        return banks;
    }
}