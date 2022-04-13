package login.IO;

import accounts.Organisation;
import accounts.bases.User;
import accounts.users.bank.Bank;
import accounts.users.police.Police;
import citizenData.elements.Citizen;
import citizenData.elements.Credit;
import citizenData.id.IdReader;
import citizenData.id.IdReaderImpl;
import database.AccountsDatabase;
import database.CitizensDatabase;
import fileOperations.FileExtraction;
import fileOperations.FileExtractor;
import login.LoginManager;

import java.util.Scanner;

public class InputOutput implements IO {

    private static InputOutput instance;

    private final Scanner scanner;
    private final Communication communication;
    private final IdReader idReader;
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
        scanner = new Scanner(System.in);

        communication = Communicator.getInstance();
        fileExtraction = FileExtractor.getInstance();
        idReader = IdReaderImpl.getInstance();
        loginManager = LoginManager.getInstance();
        citizensDatabase = CitizensDatabase.getInstance();
        accountsDatabase = AccountsDatabase.getInstance();
    }

    @Override
    public void initAdminOperations() {
        communication.showAdminOptions();

        switch (scanner.nextLine()) {
            case "1" -> {
                addData();
                communication.showSuccessfulOperationMessage();
            }
            case "2" -> communication.show(findCitizen(String.valueOf(communication.getId())).toString());
            case "3" -> {
                loginManager.logout();
                communication.showSuccessfulOperationMessage();
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    @Override
    public void initOrganisationOperations(Organisation organisation) {
        communication.showOrganisationOptions();

        switch (scanner.nextLine()) {
            case "1" -> {
                organisation.addUser(new Bank(communication.getEmail(), communication.getPassword(),
                        communication.getAddress(), communication.getName()));
                communication.showSuccessfulOperationMessage();
            }
            case "2" -> organisation.getUsers().forEach(user -> communication.show(user.toString().concat("\n")));
            case "3" -> {
                loginManager.logout();
                communication.showSuccessfulOperationMessage();
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    @Override
    public void initUserOperations(User user) {
        communication.showUserOptions();

        switch (scanner.nextLine()) {
            case "1" -> {
                String id = String.valueOf(communication.getId());
                if (user instanceof Bank) {
                    communication.show(fileExtraction.extractBankCitizenData(findCitizen(id)));
                } else {
                    communication.show(fileExtraction.extractPoliceCitizenData(findCitizen(id)));
                }
            }
            case "2" -> {
                Citizen toBeEdited = findCitizen(String.valueOf(communication.getId()));
                if (user instanceof Bank) {
                    bankEdit(toBeEdited, (Bank) user);
                } else {
                    policeEdit();
                }
                communication.showSuccessfulOperationMessage();
            }

            case "3" -> {
                communication.show(idReader.getIdInfo(communication.getId()));
            }
            case "4" -> {
                loginManager.logout();
                communication.showSuccessfulOperationMessage();
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    private Citizen findCitizen(String id) {
        return citizensDatabase.getDatabase()
                .stream()
                .filter(citizen -> citizen.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private void addData() {
        communication.showAdminDataAddingOptions();

        switch (scanner.nextLine()) {
            case "1" -> {
                new Citizen(communication.getName(), String.valueOf(communication.getId()), communication.getAddress());
                communication.showSuccessfulOperationMessage();
            }
            case "2" -> {
                new Organisation(communication.getName(), communication.getPassword());
                communication.showSuccessfulOperationMessage();
            }
            case "3" -> {
                Organisation potentiallyEmpty = askForOrganisation();
                if (potentiallyEmpty == null) {
                    communication.showIllegalInputMessage();
                    return;
                }
                if (potentiallyEmpty.getUsers().get(0) == null) {
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
            case "1" -> organisation.addUser(new Bank(communication.getEmail(), communication.getPassword(),
                    communication.getAddress(), communication.getName()));
            case "2" -> {
                if (organisation.getUsers().contains(Police.getInstance())) {
                    communication.showAlreadyExistingUserMessage();
                } else {
                    organisation.addUser(Police.getInstance());
                }
            }
            default -> communication.showIllegalInputMessage();
        }
        communication.showSuccessfulOperationMessage();
    }

    private Organisation askForOrganisation() {
        communication.show("Organisation: \n");
        String email = communication.getEmail();
        String password = communication.getPassword();

        return (Organisation) accountsDatabase.getDatabase()
                .stream()
                .filter(account -> account instanceof Organisation && account.getEmail().equals(email) &&
                        account.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private void bankEdit(Citizen citizen, Bank bank) {
        communication.showBankEditingOptions();

        switch (scanner.nextLine()) {
            case "1" -> {
                citizen.getCredits().add(new Credit(citizen, bank, communication.getAmountOfMoney()));
                communication.showSuccessfulOperationMessage();
            }
            case "2" -> {
                String id = String.valueOf(communication.getId());

                citizen.getPossessions().remove(
                        citizen.getPossessions()
                                .stream()
                                .filter(possession -> possession.getId().equals(id))
                                .findFirst()
                                .orElse(null));
                communication.showSuccessfulOperationMessage();
            }
            case "3" -> {
                double balance = communication.getAmountOfMoney();
                bank.getDatabase().getDatabase()
                        .stream()
                        .filter(bankClient -> bankClient.equals(citizen))
                        .findFirst()
                        .orElse(null)
                        .setBalance(balance);
                communication.showSuccessfulOperationMessage();
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    private void policeEdit() {
        communication.showPoliceEditingOptions();
        //TODO
    }
}
