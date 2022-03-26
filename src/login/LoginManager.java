package login;

import login.authentication.Authenticator;
import userCommunication.Communicator;

public class LoginManager {

    private final Authenticator authenticator;
    private final Communicator communicator;

    private boolean hasLoggedAccount;

    public LoginManager() {
        authenticator = new Authenticator();
        communicator = new Communicator();
    }

    public void startLoginProcess() {

        while (true) {
            do {
                communicator.welcome();

                String email = authenticator.checkEmail(communicator.getEmail());
                authenticator.checkPassword(email, communicator.getPassword());
                hasLoggedAccount = true;

            /* check account type - admin, user or an organisation
            TODO: finish when file editing options are available */
                if (authenticator.isEmailLegal(authenticator.getAdmins(), email)) {
                    initAdminOperations();
                } else if (authenticator.isEmailLegal(authenticator.getOrganisations(), email)) {
                    initOrganisationOperations();
                } else {
                    initUserOperations();
                }

            } while (hasLoggedAccount);
        }
    }

    private void initAdminOperations() {
        communicator.showAdminOptions();
        switch (communicator.getScanner().nextLine()) {
//            case "1" ->
//            case "2" ->
//            case "3" ->
//            case "4" ->
//            case "5" ->
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void initOrganisationOperations() {
        communicator.showOrganisationOptions();
    }

    private void initUserOperations() {
        communicator.showUserOptions();
        switch (communicator.getScanner().nextLine()) {
//            case "1" ->
//            case "2" ->
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void logout() {
        hasLoggedAccount = false;
    }
}
