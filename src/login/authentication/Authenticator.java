package login.authentication;

import database.operations.FileExtractor;
import userCommunication.Communicator;

import java.nio.file.Path;
import java.util.*;

public class Authenticator implements Authentication {

    private final FileExtractor fileExtractor;
    private final Communicator communicator;

    private final Path admins;
    private final Path organisations;
    private final Path users;

    public Authenticator() {
        fileExtractor = new FileExtractor();
        communicator = new Communicator();

        admins = Path.of("src", "database", "accounts",
                "Admins.csv");
        organisations = Path.of("src", "database", "accounts",
                "Organisations.csv");
        users = Path.of("src", "database", "accounts",
                "Users.csv");
    }

    @Override
    public String checkEmail(String email) {
        while (!isEmailLegal(email)) {
            communicator.showIllegalInputMessage();
            email = communicator.getEmail();
        }
        return email;
    }

    @Override
    public String checkPassword(String email, String password) {
        while (!isPasswordCorrect(email, password)) {
            communicator.showIllegalInputMessage();
            password = communicator.getPassword();
        }
        return password;
    }

    private boolean isEmailLegal(String email) {
        return isEmailLegal(admins, email) || isEmailLegal(organisations, email) || isEmailLegal(users, email);
    }

    public boolean isEmailLegal(Path path, String email) {
        List<String> emailsAndPasswords = List.of(fileExtractor.extractWholeData(path).split("\r\n"));
        Set<String> emails = new HashSet<>();

        for (int i = 0; i < emailsAndPasswords.size(); i++) {
            emails.add(emailsAndPasswords.get(i).split(",")[1]);
        }
        return emails.contains(email);
    }

    private boolean isPasswordCorrect(String email, String password) {
        List<String> emailsAndPasswords = List.of(fileExtractor.extractWholeData(admins).split("\r\n"));

        for (int i = 0; i < emailsAndPasswords.size(); i++) {
            if(emailsAndPasswords.get(i).split(",")[0].equals(email) &&
                    emailsAndPasswords.get(i).split(",")[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Path getAdmins() {
        return admins;
    }

    public Path getOrganisations() {
        return organisations;
    }

    public Path getUsers() {
        return users;
    }
}
