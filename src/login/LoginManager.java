package login;

import acc.Account;
import login.authentication.Authenticator;
import userCommunication.Communicator;

public class LoginManager {

    private Authenticator authenticator;
    private Communicator communicator;

    private Account loggedAccount;
    private boolean hasLoggedAccount;

//    public void startLoginProcess() {
//        while (true) {
//            communicator.welcome();
//            authenticator.checkPassword(authenticator.checkEmail(communicator.askForEmail()), communicator.askForPassword());
//
//        }
//    }
}
