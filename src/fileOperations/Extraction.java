package fileOperations;

import accounts.bases.Account;
import accounts.users.bank.Bank;
import accounts.users.bank.BankClient;
import citizenData.elements.Citizen;

import java.util.Set;

public interface Extraction {
    String extractPrivateCitizenData(Citizen citizen);
    Set<Citizen> getCitizens();
    Set<Account> getAccounts();
    Set<BankClient> getBankClients(Bank bank);
}
