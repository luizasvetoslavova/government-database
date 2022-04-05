package login;

import database.users.Bank;
import acc.Organisation;
import acc.User;
import citizenData.Citizen;
import citizenData.Credit;
import database.accounts.AccountsDatabase;
import database.government.CitizensDatabase;
import database.operations.FileExtractor;
import userCommunication.Communicator;

import java.util.stream.Collectors;

public class InputOutput {

    private static InputOutput instance;

    private final Communicator communicator;
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

        loginManager = LoginManager.getInstance();
        citizensDatabase = CitizensDatabase.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    public void initAdminOperations() {
        communicator.showAdminOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> addData();

            case "2" -> communicator.show(citizensDatabase.findCitizen(
                    String.valueOf(communicator.getId())).toString());

            case "3" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addData() {
        communicator.showAdminDataAddingOptions();
        switch (communicator.getScanner().nextLine()) {
            case "1" -> new Citizen(
                    communicator.getName(), String.valueOf(
                    communicator.getId()), communicator.getAddress(), communicator.getGender());

            case "2" -> new Organisation(communicator.getName(), communicator.getPassword());
            case "3" -> {
                Organisation potentiallyEmpty = askForOrganisation();

                if(potentiallyEmpty == null) {
                    communicator.showIllegalInputMessage();
                    return;
                }
                if (potentiallyEmpty.getUsers().get(0) == null) {
                    addUser(potentiallyEmpty);
                } else {
                    communicator.showAlreadyExistingUserMessage();
                }
            }
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addUser(Organisation organisation) {
        communicator.showUserTypes();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> organisation.addUser(new Bank(communicator.getEmail(), communicator.getPassword(),
                    communicator.getAddress(), communicator.getName()));
//            case "2" ->
            //TODO add police instance
            default -> communicator.showIllegalInputMessage();
        }
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
            case "1" -> addUser(organisation);
            case "2" -> organisation.getUsers().forEach(user -> communicator.show(user.toString().concat("\n")));
            case "3" -> loginManager.logout();
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
                } else {
                    policeEdit();
                }
            }
            case "3" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void bankEdit(Citizen citizen, Bank bank) {
        communicator.showBankEditingOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> citizen.getCredits().add(new Credit(bank, communicator.getAmountOfMoney()));

            case "2" -> {
                String name = communicator.getName();
                citizen.getPossessions().remove(
                        citizen.getPossessions()
                                .stream()
                                .filter(possession -> possession.getName().equals(name))
                                .collect(Collectors.toList())
                                .get(0));
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
