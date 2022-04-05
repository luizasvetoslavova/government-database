package database.users;

import database.operations.FileEditor;

import java.io.File;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BankDatabase {

    private FileEditor fileEditor;

    private Bank bank;
    private Set<BankClient> clients;

    public BankDatabase(Bank bank) {
        this.bank = bank;
        fileEditor = FileEditor.getInstance();

        new File(String.valueOf(Path.of("src", "database", "organisations", "users",
                "Bank" + bank.getSerialNumber() + ".csv")));

        Path bankDatabase = Path.of("src", "database", "users",
                "Bank" + bank.getSerialNumber() + ".csv");

        fileEditor.inputData(bankDatabase, bank.bankInfoToString());
        fileEditor.inputData(Path.of("src", "database", "accounts", "Users.csv"),
                bank.accountInfoToString());

        clients = new HashSet<>();
    }

    public BankClient findCitizen(String id) {
        return clients
                .stream()
                .filter(bankClient -> bankClient.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }
}
