package login;

import accounts.bases.Account;
import accounts.Admin;
import accounts.Organisation;
import accounts.bases.User;
import fileOperations.Extraction;
import fileOperations.Extractor;
import login.IO.Communication;
import login.IO.Communicator;
import login.IO.IO;
import login.IO.InputOutput;

public class LoginManager {

    private static final LoginManager instance = new LoginManager();

    private final Communication communication;
    private final IO inputOutput;
    private boolean hasLoggedAccount;
    private Extraction extraction;

    public static LoginManager getInstance() {
        return instance;
    }

    private LoginManager() {
        communication = Communicator.getInstance();
        inputOutput = InputOutput.getInstance();
        extraction = Extractor.getInstance();
    }

    public void startLoginProcess() {
        while (true) {
            communication.welcome();
            String email;

            while (!isDataCorrect(email = communication.getEmail(), communication.getPassword())) {
                communication.showIllegalInputMessage();
            }

            Account logged = findByEmail(email);
            hasLoggedAccount = true;

            do {
                if (logged instanceof Admin) {
                    inputOutput.initAdminOperations();
                } else if (logged instanceof Organisation) {
                    inputOutput.initOrganisationOperations((Organisation) logged);
                } else if (logged instanceof User) {
                    inputOutput.initUserOperations((User) logged);
                } else {
                    communication.showIllegalInputMessage();
                }
            } while (hasLoggedAccount);
        }
    }

    private boolean isDataCorrect(String email, String password) {
        return extraction.getAccounts()
                .stream()
                .anyMatch(account -> account.getEmail().equals(email) && account.getPassword().equals(password));
    }

    private Account findByEmail(String email) {
        return extraction.getAccounts()
                .stream()
                .filter(account -> account.getEmail().equals(email))
                .findAny()
                .orElse(null);
    }

    public void logout() {
        hasLoggedAccount = false;
    }
}
