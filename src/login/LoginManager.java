package login;

import acc.Account;
import acc.Admin;
import acc.Organisation;
import acc.User;
import database.accounts.AccountsDatabase;
import login.authentication.Authenticator;
import userCommunication.Communicator;

public class LoginManager {

    private static LoginManager instance;

    private final Authenticator authenticator;
    private final Communicator communicator;
    private final InputOutput inputOutput;
    private final AccountsDatabase accountsDatabase;

    private boolean hasLoggedAccount;

    public static LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    private LoginManager() {
        authenticator = new Authenticator();
        communicator = new Communicator();
        inputOutput = InputOutput.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    public void startLoginProcess() {

        while (true) {
            communicator.welcome();

            String email = authenticator.checkEmail(communicator.getEmail());
            Account logged = accountsDatabase
                    .findAccount(email, authenticator.checkPassword(email, communicator.getPassword()));
            hasLoggedAccount = true;

            do {
                if (logged instanceof Admin) {
                    inputOutput.initAdminOperations();

                } else if (logged instanceof Organisation) {
                    inputOutput.initOrganisationOperations((Organisation) logged);

                } else if (logged instanceof User) {
                    inputOutput.initUserOperations((User) logged);

                } else {
                    communicator.showIllegalInputMessage();
                }

            } while (hasLoggedAccount);
        }
    }

    public void logout() {
        hasLoggedAccount = false;
    }
}
