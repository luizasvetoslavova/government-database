package userCommunication;

import citizenData.lists.Country;
import citizenData.lists.Gender;
import citizenData.lists.PossessionType;
import citizenData.lists.PunishmentType;
import userCommunication.validation.Validator;

import java.util.Date;
import java.util.Scanner;

public class Communicator implements Communication {

    private final Validator validator;
    private final Scanner scanner;

    public Communicator() {
        validator = new Validator();
        scanner = new Scanner(System.in);
    }

    @Override
    public String getEmail() {
        System.out.print("E-mail: ");
        return scanner.nextLine();
    }

    @Override
    public String getPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }

    @Override
    public String getName() {
        System.out.print("Name: ");
        return scanner.nextLine();
    }

    @Override
    public String getAddress() {
        System.out.print("Address: ");
        return scanner.nextLine();
    }

    @Override
    public Date getDate() {
        System.out.print("Date in format DD/MM/YYYY: ");
        return validator.checkDate(scanner.nextLine());
    }

    @Override
    public PunishmentType getPunishmentType() {
        System.out.print("Punishment type: \n" +
                "1. Fining \n" +
                "2. Imprisonment \n" +
                "3. Boarding school \n" +
                "4. Suspended sentence \n" +
                "5. Ban on crossing border \n" +
                "6. House arrest \n" +
                "7. Service work \n" +
                "Your choice: ");

        return switch (scanner.nextLine()) {
            case "1" -> PunishmentType.FINING;
            case "2" -> PunishmentType.IMPRISONMENT;
            case "3" -> PunishmentType.BOARDING_SCHOOL;
            case "4" -> PunishmentType.SUSPENDED_SENTENCE;
            case "5" -> PunishmentType.BAN_ON_CROSSING_BORDER;
            case "6" -> PunishmentType.HOUSE_ARREST;
            case "7" -> PunishmentType.SERVICE_WORK;
            default -> getPunishmentType();
        };
    }

    @Override
    public PossessionType getPossessionType() {
        System.out.print("Possession types: \n" +
                "1. Vehicle \n" +
                "2. Land \n" +
                "3. Building \n" +
                "4. Firearm \n" +
                "Your choice: ");

        return switch (scanner.nextLine()) {
            case "1" -> PossessionType.VEHICLE;
            case "2" -> PossessionType.LAND;
            case "3" -> PossessionType.BUILDING;
            case "4" -> PossessionType.FIREARM;
            default -> getPossessionType();
        };
    }

    @Override
    public Gender getGender() {
        System.out.print("Gender: \n" +
                "1. Male \n" +
                "2. Female \n" +
                "Your choice: ");

        return switch (scanner.nextLine()) {
            case "1" -> Gender.MALE;
            case "2" -> Gender.FEMALE;
            default -> getGender();
        };
    }

    public double getAmountOfMoney() {
        System.out.println("Amount of money: ");
        return validator.checkAmountOfMoney(scanner.nextLine());
    }

    @Override
    public double getPercentage() {
        System.out.println("Percent: ");
        return validator.checkPercentage(scanner.nextLine());
    }

    @Override
    public long getId() {
        System.out.println("ID: ");
        return validator.checkId(scanner.nextLine());
    }

    @Override
    public Country getCountry() {
        System.out.println("Country short record (ex. BG):");
        return validator.checkCountry(scanner.nextLine().toUpperCase());
    }

    @Override
    public void showIllegalInputMessage() {
        System.out.print("Illegal input, please try again: ");
    }

    @Override
    public void showAlreadyExistingUserMessage() {
        System.out.println("First user of that organisation already exists.");
    }

    @Override
    public void showAdminOptions() {
        System.out.print("You logged as an admin. You have control over all organisations. \n" +
                "1. Add data \n" +
                "2. View data for citizen " +
                "3. Logout \n" +
                "Your choice: ");
    }

    @Override
    public void showAdminDataAddingOptions() {
        System.out.print("Add new: \n" +
                "1. Citizen \n" +
                "2. Organisation \n" +
                "3. First organisation user \n" +
                "Your choice: ");
    }

    @Override
    public void showOrganisationOptions() {
        System.out.print("You logged as an organisation. \n" +
                "1. Add bank \n" +
                "2. View all users of yours " +
                "3. Logout \n" +
                "Your choice: ");
    }

    @Override
    public void showUserOptions() {
        System.out.print("You logged as a user. \n" +
                "1. View data for citizen \n" +
                "2. Edit data for citizen \n" +
                "3. Get ID information \n" +
                "4. Logout \n" +
                "Your choice: ");
    }

    @Override
    public void showBankEditingOptions() {
        System.out.print("1. Add credit \n" +
                "2. Take possession \n" +
                "3. Change balance \n");
    }

    @Override
    public void showPoliceEditingOptions() {
        System.out.print("1. Add crime \n" +
                "2. Take possession \n" +
                "3. Add crossing border \n");
    }

    @Override
    public void welcome() {
        System.out.println("Welcome to the government interactive database! \n");
    }

    @Override
    public void showSuccessfulOperationMessage() {
        System.out.println("Operation successful! \n");
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    public Scanner getScanner() {
        return scanner;
    }
}