package login.IO;

import accounts.Organisation;
import accounts.bases.User;
import accounts.users.bank.Bank;
import accounts.users.police.Police;
import citizenData.elements.Citizen;
import citizenData.elements.Credit;
import citizenData.id.IdReader;
import citizenData.id.IdReaderImpl;
import citizenData.lists.Country;
import citizenData.lists.PossessionType;
import citizenData.lists.PunishmentType;
import citizenData.lists.UserPrivacyStatus;
import fileOperations.Extraction;
import fileOperations.Extractor;
import login.LoginManager;

import java.util.List;
import java.util.Scanner;

public class InputOutput implements IO {

    private static final InputOutput instance = new InputOutput();

    private final Scanner scanner;
    private final Communication communication;
    private final IdReader idReader;
    private final LoginManager loginManager;
    private final Extraction extraction;

    public static InputOutput getInstance() {
        return instance;
    }

    private InputOutput() {
        scanner = new Scanner(System.in);

        communication = Communicator.getInstance();
        extraction = Extractor.getInstance();
        idReader = IdReaderImpl.getInstance();
        loginManager = LoginManager.getInstance();
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
                if (user.getPrivacyStatus() == UserPrivacyStatus.PRIVATE) {
                    communication.show(extraction.extractPrivateCitizenData(findCitizen(id)));
                } else {
                    communication.show((findCitizen(id).publicDataToString()));
                }
            }
            case "2" -> {
                Citizen toBeEdited = findCitizen(String.valueOf(communication.getId()));
                if (user instanceof Bank) {
                    bankEdit(toBeEdited, (Bank) user);
                } else {
                    policeEdit(toBeEdited, (Police) user);
                    ;
                }
                communication.showSuccessfulOperationMessage();
            }

            case "3" -> communication.show(idReader.getIdInfo(communication.getId()));
            case "4" -> {
                loginManager.logout();
                communication.showSuccessfulOperationMessage();
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    private Citizen findCitizen(String id) {
        return extraction.getCitizens()
                .stream()
                .filter(citizen -> citizen.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private void addData() {
        communication.showAdminDataAddingOptions();

        switch (scanner.nextLine()) {
            case "1" -> new Citizen(communication.getName(), String.valueOf(communication.getId()),
                    communication.getAddress());
            case "2" -> new Organisation(communication.getEmail(), communication.getPassword());
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
    }

    private Organisation askForOrganisation() {
        communication.show("Organisation: \n");
        String email = communication.getEmail();
        String password = communication.getPassword();

        return (Organisation) extraction.getAccounts()
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
            }
            case "2" -> {
                String id = String.valueOf(communication.getId());

                citizen.getPossessions().remove(
                        citizen.getPossessions()
                                .stream()
                                .filter(possession -> possession.getId().equals(id))
                                .findFirst()
                                .orElse(null));
            }
            case "3" -> {
                double balance = communication.getAmountOfMoney();
                extraction.getBankClients(bank)
                        .stream()
                        .filter(bankClient -> bankClient.equals(citizen))
                        .findFirst()
                        .orElse(null)
                        .setBalance(balance);
            }
            default -> communication.showIllegalInputMessage();
        }
    }

    private void policeEdit(Citizen citizen, Police police) {
        communication.showPoliceEditingOptions();
        switch (scanner.nextLine()) {
            case "1" -> {
                List<PunishmentType> punishments = null;
                assert false;
                punishments.add(communication.getPunishmentType());
                communication.showSuccessfulOperationMessage();
                //add crime
            }
            case "2" -> {
                List<PossessionType> possessions = null;
                assert false;
                possessions.remove(communication.getPossessionType());
                communication.showSuccessfulOperationMessage();
                //Take possession
            }
            case "3" -> {
                List<Country> countries = null;
                assert false;
                countries.add(communication.getCountry());
                communication.showSuccessfulOperationMessage();
                //Add crossing border
            }
        }
    }
}
