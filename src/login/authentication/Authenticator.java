package login.authentication;

import database.operations.FileExtractor;

import java.nio.file.Path;
import java.util.*;

public class Authenticator implements Authentication {
    private final Path admins;
    private final Path organisations;
    private final Path users;

    private FileExtractor fileExtractor;

    public Authenticator() {
        admins = Path.of("src", "database", "accounts",
                "Admins.csv");
        organisations = Path.of("src", "database", "accounts",
                "Organisations.csv");
        users = Path.of("src", "database", "accounts",
                "Users.csv");
    }

    @Override
    public boolean isEmailLegal(String email) {
        return isEmailLegal(admins, email) || isEmailLegal(organisations, email) || isEmailLegal(users, email);
    }

    private boolean isEmailLegal(Path path, String email) {
        List<String> emailsAndPasswords = List.of(fileExtractor.extractWholeData(path).split("\r\n"));
        Set<String> emails = new HashSet<>();

        for (int i = 1; i < emailsAndPasswords.size(); i++) {
            emails.add(emailsAndPasswords.get(i).split(",")[1]);
        }
        return emails.contains(email);
    }

    @Override
    public boolean isPasswordCorrect(String email, String password) {
        List<String> emailsAndPasswords = List.of(fileExtractor.extractWholeData(admins).split("\r\n"));

        for (int i = 1; i < emailsAndPasswords.size(); i++) {
            if(emailsAndPasswords.get(i).split(",")[0].equals(email) &&
                    emailsAndPasswords.get(i).split(",")[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
