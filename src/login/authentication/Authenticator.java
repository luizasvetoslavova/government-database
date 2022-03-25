package login.authentication;

import java.nio.file.Path;

public class Authenticator implements Authentication {

    Path admins = Path.of("src", "database", "accounts",
            "Admins.tsv");
    Path organisations = Path.of("src", "database", "accounts",
            "Organisations.tsv");
    Path users = Path.of("src", "database", "accounts",
            "Users.tsv");

    @Override
    public boolean isEmailLegal() {
        return false;
    }

    @Override
    public boolean isPasswordCorrect() {
        return false;
    }

    @Override
    public String repeatIncorrectPassword() {
        return null;
    }

    @Override
    public String repeatIncorrectEmail() {
        return null;
    }
}
