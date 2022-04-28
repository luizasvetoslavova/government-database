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
    private static final String accountsFile = "accounts.database";

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
        return getObjects(citizensFile);
    }

    @Override
    public Set<Account> getAccounts() {
        return getObjects(accountsFile);
    }

    @Override
    public Set<BankClient> getBankClients(Bank bank) {
        return getObjects(bank.getBankDatabaseName());
    }

    private <T> Set<T> getObjects(String file) {
        Set<T> result = new HashSet<>();
        Arrays.stream(extractWholeData(file).split("\r\n\r\n\r\n"))
                .forEach(element -> result.add(convertObject(file, element)));
        return result;
    }

    @SuppressWarnings("unchecked")
    private <T> T convertObject(String file, String element) {
        T elementAsObject = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            elementAsObject = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return elementAsObject;
    }

    private String extractWholeData(String file) {
        StringBuilder sb = new StringBuilder();

        try (ByteArrayInputStream is = new ByteArrayInputStream(file.getBytes())) {
            while (is.read() == -1) {
                sb.append(is.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}