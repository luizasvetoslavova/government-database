package login;

import accounts.bases.Account;
import accounts.Admin;
import accounts.Organisation;
import accounts.bases.User;
import database.AccountsDatabase;
import login.IO.Communication;
import login.IO.Communicator;
import login.IO.IO;
import login.IO.InputOutput;
import login.validation.Authentication;
import login.validation.Authenticator;

public class LoginManager {

    private static LoginManager instance;

    private final Authentication authentication;
    private final Communication communication;
    private final IO inputOutput;
    private final AccountsDatabase accountsDatabase;

    private boolean hasLoggedAccount;

    public static LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    private LoginManager() {
        authentication = Authenticator.getInstance();
        communication = Communicator.getInstance();
        inputOutput = InputOutput.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    public void startLoginProcess() {

        while (true) {
            communication.welcome();

            String email = communication.getEmail();
            authentication.checkInputData(email, communication.getPassword());

            Account logged = accountsDatabase.findBy(email);
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

    public void logout() {
        hasLoggedAccount = false;
    }
}
