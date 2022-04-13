package login.validation;

import database.AccountsDatabase;
import login.IO.Communication;
import login.IO.Communicator;

public class Authenticator implements Authentication {

    private static Authenticator instance;

    private final Communication communication;

    public static Authenticator getInstance() {
        if (instance == null) {
            instance = new Authenticator();
        }
        return instance;
    }

    private Authenticator() {
        communication = Communicator.getInstance();
    }

    @Override
    public void checkInputData(String email, String password) {
        while (!isDataCorrect(email, password)) {
            communication.showIllegalInputMessage();
            email = communication.getEmail();
            password = communication.getPassword();
        }
    }

    public boolean isDataCorrect(String email, String password) {
        return AccountsDatabase.getInstance().getDatabase()
                .stream()
                .anyMatch(account -> account.getEmail().equals(email) && account.getPassword().equals(password));
    }
}
