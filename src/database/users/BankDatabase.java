package database.users;

import database.operations.FileEditor;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class BankDatabase {

    private List<BankClient> clients;

    public BankDatabase(Bank bank) {
        clients = new ArrayList<>();

        Path bankFilePath = Path.of("src", "database", "users",
                "Bank" + bank.getSerialNumber() + ".csv");
        new File(String.valueOf(bankFilePath));

        FileEditor fileEditor = FileEditor.getInstance();
        fileEditor.inputData(bankFilePath, bank.bankInfoToString() + "\n" + toString());
        clients.forEach(client -> fileEditor.inputData(bankFilePath, client.toString().concat("\n")));
    }

    public BankClient findCitizen(String id) {
        return clients
                .stream()
                .filter(bankClient -> bankClient.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<BankClient> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "BankDatabase{" +
                "clients=" + clients +
                '}';
    }
}
