package login.IO;

import accounts.users.bank.Bank;
import accounts.Organisation;
import accounts.bases.User;
import citizenData.elements.Citizen;
import citizenData.elements.Credit;
import database.AccountsDatabase;
import database.CitizensDatabase;
import fileOperators.FileExtraction;
import fileOperators.FileExtractor;
import login.LoginManager;

import java.util.Scanner;

public class InputOutput implements IO {

    private static InputOutput instance;

    private final Communication communication;
    private final Scanner scanner;

    private final LoginManager loginManager;
    private final FileExtraction fileExtraction;
    private final CitizensDatabase citizensDatabase;
    private final AccountsDatabase accountsDatabase;

    public static InputOutput getInstance() {
        if (instance == null) {
            instance = new InputOutput();
        }
        return instance;
    }

    private InputOutput() {
        communication = new Communicator();
        scanner = new Scanner(System.in);

        fileExtraction = FileExtractor.getInstance();
        loginManager = LoginManager.getInstance();
        citizensDatabase = CitizensDatabase.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    @Override
    public void initAdminOperations() {
        communication.showAdminOptions();

        switch (scanner.nextLine()) {
            case "1" -> addData();
            case "2" -> communication.show(citizensDatabase.findBy(String.valueOf(communication.getId())).toString());
            case "3" -> loginManager.logout();
            default -> communication.showIllegalInputMessage();
        }
    }

    @Override
    public void initOrganisationOperations(Organisation organisation) {
        communication.showOrganisationOptions();

        switch (scanner.nextLine()) {
            case "1" -> addUser(organisation);
            case "2" -> organisation.getUsers().forEach(user -> communication.show(user.toString().concat("\n")));
            case "3" -> loginManager.logout();
            default -> communication.showIllegalInputMessage();
        }
    }

    @Override
    public void initUserOperations(User user) {
        communication.showUserOptions();

        switch (scanner.nextLine()) {
            case "1" -> {
                if (user instanceof Bank) {
                    communication.show(fileExtraction.extractBankCitizenData(
                            citizensDatabase.findBy(String.valueOf(communication.getId()))));
                } else {
                    communication.show(fileExtraction.extractPoliceCitizenData(
                            citizensDatabase.findBy(String.valueOf(communication.getId()))));
                }
            }
            case "2" -> {
                Citizen toBeEdited = citizensDatabase.findBy(String.valueOf(communication.getId()));

                if (user instanceof Bank) {
                    bankEdit(toBeEdited, (Bank) user);
                } else {
                    policeEdit();
                }
            }
            case "3" -> loginManager.logout();
            default -> communication.showIllegalInputMessage();
        }
    }

    private void addData() {
        communication.showAdminDataAddingOptions();
        switch (scanner.nextLine()) {

            case "1" -> new Citizen(communication.getName(), String.valueOf(
                    communication.getId()), communication.getAddress());

            case "2" -> new Organisation(communication.getName(), communication.getPassword());
            case "3" -> {
                Organisation potentiallyEmpty = askForOrganisation();

                if (potentiallyEmpty == null) {
                    communication.showIllegalInputMessage();
                    return;
                }
                if (potentiallyEmpty.getUsers().isEmpty()) {
                    addUser(potentiallyEmpty);

                } else {
                    communication.showAlreadyExistingUserMessage();
                }
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    private void addUser(Organisation organisation) {
        communication.showUserTypes();

        switch (scanner.nextLine()) {
            case "1" -> {
                Bank newBank = new Bank(communication.getEmail(), communication.getPassword(),
                        communication.getAddress(), communication.getName());
                organisation.addUser(newBank);
            }
//            case "2" ->
            //TODO add police instance
            default -> communication.showIllegalInputMessage();
        }
    }

    private Organisation askForOrganisation() {
        communication.show("Organisation: \n");
        String email = communication.getEmail();
        String password = communication.getPassword();

        return (Organisation) accountsDatabase.getDatabase()
                .stream()
                .filter(account -> account instanceof Organisation && account.getEmail().equals(email) &&
                        account.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    private void bankEdit(Citizen citizen, Bank bank) {
        communication.showBankEditingOptions();

        switch (scanner.nextLine()) {
            case "1" -> citizen.getCredits().add(new Credit(citizen, bank, communication.getAmountOfMoney()));
            case "2" -> {
                String name = communication.getName();
                citizen.getPossessions().remove(
                        citizen.getPossessions()
                                .stream()
                                .filter(possession -> possession.getName().equals(name))
                                .findFirst()
                                .orElse(null));
            }
            case "3" -> bank.getDatabase().findBy(String.valueOf(communication.getId()))
                    .setBalance(communication.getAmountOfMoney());
            default -> communication.showIllegalInputMessage();
        }
    }

    private void policeEdit() {
        communication.showPoliceEditingOptions();
        //TODO
    }
}
