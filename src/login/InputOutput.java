package login;

import acc.Bank;
import acc.Organisation;
import acc.User;
import citizenData.Citizen;
import citizenData.Credit;
import database.accounts.AccountsDatabase;
import database.government.CitizensDatabase;
import database.operations.FileExtractor;
import database.organisations.BankDatabase;
import userCommunication.Communicator;

import java.util.stream.Collectors;

public class InputOutput {

    private static InputOutput instance;

    private final Communicator communicator;
    private final LoginManager loginManager;
    private final FileExtractor fileExtractor;
    private final CitizensDatabase citizensDatabase;
    private final BankDatabase bankDatabase;

    public static InputOutput getInstance() {
        if (instance == null) {
            instance = new InputOutput();
        }
        return instance;
    }

    private InputOutput() {
        communicator = new Communicator();
        fileExtractor = new FileExtractor();

        loginManager = LoginManager.getInstance();
        citizensDatabase = CitizensDatabase.getInstance();
        bankDatabase = BankDatabase.getInstance();
    }

    public void initAdminOperations() {
        communicator.showAdminOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> addData();
            case "2" -> communicator.show(citizensDatabase.findCitizen(communicator.getId()).toString());
            case "3" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addData() {
        communicator.showAdminDataAddingOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> new Citizen(
                    communicator.getName(), communicator.getId(), communicator.getAddress());
            case "2" -> new Organisation(communicator.getName(), communicator.getPassword());
            case "3" -> {
                if (AccountsDatabase.getInstance().getOrganisations().isEmpty()) {
                    new Organisation(communicator.getName(), communicator.getPassword());
                } else {
                    communicator.showAlreadyExistingUserMessage();
                }
            }
            default -> communicator.showIllegalInputMessage();
        }
    }

    public void initOrganisationOperations(Organisation organisation) {
        communicator.showOrganisationOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> addUser(organisation);
            case "2" -> organisation.getUsers().forEach(user -> communicator.show(user.toString()));
            case "3" -> loginManager.logout();
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void addUser(Organisation organisation) {
        communicator.showUserTypes();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> organisation.addUser(new Bank(communicator.getEmail(), communicator.getPassword(),
                    communicator.getAddress(), communicator.getName()));
            //TODO new police instance
            default -> communicator.showIllegalInputMessage();
        }
    }

    public void initUserOperations(User user) {
        communicator.showUserOptions();

        switch (communicator.getScanner().nextLine()) {
            case "1" -> {
                if (user instanceof Bank) {
                    communicator.show(fileExtractor.extractBankCitizenData());
                } else {
                    communicator.show(fileExtractor.extractPoliceCitizenData());
                }
            }

            case "2" -> {
                Citizen toBeEdited = citizensDatabase.findCitizen(communicator.getId());
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
//            case "3" ->
            //TODO add balance change function
            default -> communicator.showIllegalInputMessage();
        }
    }

    private void policeEdit() {
        communicator.showPoliceEditingOptions();
        //TODO
    }
}
