package database.organisations;

import citizenData.Citizen;
import login.LoginManager;
;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankDatabase {

    private static BankDatabase instance;

    private Set<Citizen> clients;
    private List<Long> balances;
    private List<Long> debts;
    private List<String> addresses;
    private List<String> phoneNumbers;
    private List<String> emails;

    public static BankDatabase getInstance() {
        if(instance == null) {
            instance = new BankDatabase();
        }
        return instance;
    }

    private BankDatabase() {
        clients = new HashSet<>();
        balances = new ArrayList<>();
        debts = new ArrayList<>();
        addresses = new ArrayList<>();
        phoneNumbers = new ArrayList<>();
        emails = new ArrayList<>();
    }

    public List<Long> getBalances() {
        return balances;
    }
}
