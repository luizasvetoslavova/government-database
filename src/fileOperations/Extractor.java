package fileOperations;

import accounts.bases.Account;
import accounts.users.bank.Bank;
import accounts.users.bank.BankClient;
import citizenData.elements.Citizen;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Extractor implements Extraction {

    private static final String citizensFile = "citizens.database";
    private static final String accountsFile = "citizens.database";

    private static final Extractor instance = new Extractor();

    public static Extractor getInstance() {
        return instance;
    }

    @Override
    public String extractPrivateCitizenData(Citizen citizen) {
        StringBuilder data = new StringBuilder();
        data.append(citizen.privateDataToString());
        citizen.getRelatives().forEach(relative -> data.append(relative.getCredits()));
        return data.toString();
    }

    @Override
    public Set<Citizen> getCitizens() {
        Set<Citizen> result = new HashSet<>();
        Arrays.stream(extractWholeData(citizensFile).split("\r\n"))
                .forEach(citizen -> result.add((Citizen) convertObject(citizen)));

        return result;
    }

    @Override
    public Set<Account> getAccounts() {
        Set<Account> result = new HashSet<>();
        Arrays.stream(extractWholeData(accountsFile).split("\r\n"))
                .forEach(account -> result.add((Account) convertObject(account)));

        return result;
    }

    @Override
    public Set<BankClient> getBankClients(Bank bank) {
        Set<BankClient> result = new HashSet<>();
        Arrays.stream(extractWholeData(bank.getBankDatabaseName()).split("\r\n"))
                .forEach(client -> result.add((BankClient) convertObject(client)));

        return result;
    }

    private Object convertObject(String element) {
        Object obj = null;

        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(element))) {
            obj = objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    private String extractWholeData(String file) {
        StringBuilder sb = new StringBuilder();

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
            while (is.readObject() != null) {
                sb.append(is.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}