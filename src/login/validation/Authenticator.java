package login.validation;

import accounts.bases.Account;
import fileOperations.Extraction;
import fileOperations.Extractor;
import login.IO.Communication;
import login.IO.Communicator;

public class Authenticator implements Authentication {

    private final Extraction extraction;

    private static final Authenticator instance = new Authenticator();

    private final Communication communication;

    public static Authenticator getInstance() {
        return instance;
    }

    private Authenticator() {
        communication = Communicator.getInstance();
        extraction = Extractor.getInstance();
    }

    @Override
    public void checkInputData(String email, String password) {
        while (!isDataCorrect(email, password)) {
            communication.showIllegalInputMessage();
            email = communication.getEmail();
            password = communication.getPassword();
        }
    }

    @Override
    public Account findByEmail(String email) {
        return extraction.getAccounts()
                .stream()
                .filter(account -> account.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public boolean isDataCorrect(String email, String password) {
        return extraction.getAccounts()
                .stream()
                .anyMatch(account -> account.getEmail().equals(email) && account.getPassword().equals(password));
    }
}
