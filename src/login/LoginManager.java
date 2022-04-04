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
    private final InputOutput inputOutputManager;
    private final AccountsDatabase accountsDatabase;

    private Account logged;
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
        inputOutputManager = InputOutput.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    public void startLoginProcess() {

        while (true) {

            do {
                communicator.welcome();

                String email = authenticator.checkEmail(communicator.getEmail());
                logged = AccountsDatabase.getInstance()
                        .findAccount(email, authenticator.checkPassword(email, communicator.getPassword()));

                hasLoggedAccount = true;

                if (logged instanceof Admin) {
                    inputOutputManager.initAdminOperations();

                } else if (logged instanceof Organisation) {
                    inputOutputManager.initOrganisationOperations((Organisation) logged);

                } else if (logged instanceof User) {
                    inputOutputManager.initUserOperations((User) logged);

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
