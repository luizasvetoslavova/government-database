package login;

import database.operations.FileEditor;
import database.users.Bank;
import acc.Organisation;
import acc.User;
import citizenData.Citizen;
import citizenData.Credit;
import citizenData.IdReaderImpl;
import database.accounts.AccountsDatabase;
import database.government.CitizensDatabase;
import database.operations.FileExtractor;
import userCommunication.Communicator;

import java.nio.file.Path;
import java.util.stream.Collectors;

public class InputOutput {

    private static InputOutput instance;

    private final Communicator communicator;

    private final IdReaderImpl idReader;
    private final LoginManager loginManager;
    private final FileExtractor fileExtractor;

    private final CitizensDatabase citizensDatabase;
    private final AccountsDatabase accountsDatabase;

    public static InputOutput getInstance() {
        if (instance == null) {
            instance = new InputOutput();
        }
        return instance;
    }

    private InputOutput() {

        communicator = new Communicator();
        fileExtractor = FileExtractor.getInstance();
        idReader = new IdReaderImpl();

        loginManager = LoginManager.getInstance();
        citizensDatabase = CitizensDatabase.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    public void initAdminOperations() {
        communicator.showAdminOptions();

        switch (communicator.getScanner().nextLine()) {

            case "2" -> communicator.show(citizensDatabase.findCitizen(
                    String.valueOf(communicator.getId())).toString());

            case "1" -> {
                addData();
                communicator.showSuccessfulOperationMessage();
            }

            case "3" -> {
                loginManager.logout();
                communicator.showSuccessfulOperationMessage();
            }
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addData() {
        communicator.showAdminDataAddingOptions();
        switch (communicator.getScanner().nextLine()) {
            case "1" -> {
                new Citizen(
                        communicator.getName(), String.valueOf(communicator.getId()),
                        communicator.getAddress(), communicator.getGender());
                communicator.showSuccessfulOperationMessage();
            }

            case "2" -> {
                new Organisation(communicator.getName(), communicator.getPassword());
                communicator.showSuccessfulOperationMessage();
            }

            case "3" -> {
                Organisation potentiallyEmpty = askForOrganisation();

                if (potentiallyEmpty == null) {
                    communicator.showIllegalInputMessage();
                    return;
                }
                if (potentiallyEmpty.getUsers().get(0) == null) {
                    addBank(potentiallyEmpty);

                } else {
                    communicator.showAlreadyExistingUserMessage();
                }
            }
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addBank(Organisation organisation) {
        organisation.addUser(new Bank(communicator.getEmail(), communicator.getPassword(),
                communicator.getAddress(), communicator.getName()));
        communicator.showSuccessfulOperationMessage();
    }

    private Organisation askForOrganisation() {
        communicator.show("Organisation: \n");

        return accountsDatabase.getOrganisations()
                .stream()
                .filter(organisation -> organisation.getEmail().equals(communicator.getEmail()) &&
                        organisation.getPassword().equals(communicator.getPassword()))
                .collect(Collectors.toList())
                .get(0);
    }

    public void initOrganisationOperations(Organisation organisation) {
        communicator.showOrganisationOptions();

        switch (communicator.getScanner().nextLine()) {
            case "2" -> organisation.getUsers().forEach(user -> communicator.show(user.toString().concat("\n")));
            case "3" -> loginManager.logout();
            case "1" -> {
                organisation.addUser(new Bank(communicator.getEmail(), communicator.getPassword(),
                        communicator.getAddress(), communicator.getName()));
                communicator.showSuccessfulOperationMessage();
            }
            default -> communicator.showIllegalInputMessage();
        }
    }

    public void initUserOperations(User user) {
        communicator.showUserOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> {
                if (user instanceof Bank) {
                    communicator.show(fileExtractor.extractBankCitizenData(
                            citizensDatabase.findCitizen(String.valueOf(communicator.getId()))));
                } else {
                    communicator.show(fileExtractor.extractPoliceCitizenData(
                            citizensDatabase.findCitizen(String.valueOf(communicator.getId()))));
                }
            }

            case "2" -> {
                Citizen toBeEdited = citizensDatabase.findCitizen(String.valueOf(communicator.getId()));

                if (user instanceof Bank) {
                    bankEdit(toBeEdited, (Bank) user);
                    communicator.showSuccessfulOperationMessage();
                } else {
                    policeEdit();
                    communicator.showSuccessfulOperationMessage();
                }
            }

            case "3" -> {
                idReader.getIdInfo(Long.parseLong(String.valueOf(communicator.getId())));
                communicator.showSuccessfulOperationMessage();
            }

            case "4" -> {
                loginManager.logout();
                communicator.showSuccessfulOperationMessage();
            }

            default -> communicator.showIllegalInputMessage();
        }
    }

    private void bankEdit(Citizen citizen, Bank bank) {
        communicator.showBankEditingOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> {
                citizen.getCredits().add(new Credit(bank, communicator.getAmountOfMoney()));
                communicator.showSuccessfulOperationMessage();
            }
            case "2" -> {
                String name = communicator.getName();
                citizen.getPossessions().remove(
                        citizen.getPossessions()
                                .stream()
                                .filter(possession -> possession.getName().equals(name))
                                .collect(Collectors.toList())
                                .get(0));
                communicator.showSuccessfulOperationMessage();
            }
            case "3" -> bank.getDatabase().findCitizen(String.valueOf(communicator.getId()))
                    .setBalance(communicator.getAmountOfMoney());
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void policeEdit() {
        communicator.showPoliceEditingOptions();
        //TODO
    }
}
