package login;

import acc.Account;
import acc.Bank;
import acc.User;
import database.operations.FileExtractor;
import userCommunication.Communicator;

import java.nio.file.Path;

public class InputOutputManager {

    private final Communicator communicator;
    private final LoginManager loginManager;
    private final FileExtractor fileExtractor;

    private Path citizens = Path.of("src", "database", "government", "Citizens.psv");

    public InputOutputManager() {
        communicator = new Communicator();
        loginManager = LoginManager.getInstance();
        fileExtractor = new FileExtractor();
    }

    public void initAdminOperations() {
        communicator.showAdminOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> addData();
            case "2" -> editData();

            case "3" -> communicator.show(
                    fileExtractor.extractWholeCitizenData(citizens, String.valueOf(communicator.getId())));

            case "4" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addData() {
        communicator.showAdminDataAddingOptions();
        switch (communicator.getScanner().nextLine()) {
            case "1" ->
            case "2" ->
            case "3" ->
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void editData() {
        communicator.showAdminDataEditingOptions();
        switch (communicator.getScanner().nextLine()) {
            case "1" ->
            case "2" ->
            default -> communicator.showIllegalInputMessage();
        }
    }

    public void initOrganisationOperations() {
        communicator.showOrganisationOptions();
        switch (communicator.getScanner().nextLine()) {
            case "1" ->
            case "2" ->
            case "3" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }

    public void initUserOperations(User user) {
        communicator.showUserOptions();
        switch (communicator.getScanner().nextLine()) {
            case "1" -> {
                if(user instanceof Bank) {
                    communicator.show(fileExtractor.extractBankCitizenData());
                } else {
                    communicator.show(fileExtractor.extractPoliceCitizenData());
                }
            }
            case "2" ->
            case "3" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }
}
