package login.validation;

import accounts.bases.Account;

public interface Authentication {
    void checkInputData(String email, String password);
    Account findByEmail(String email);
}

