package userCommunication.validation;

import citizenData.Country;
import userCommunication.Communicator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator implements Validation {

    private final Communicator communicator;

    public Validator() {
        communicator = new Communicator();
    }

    @Override
    public long checkId(String input) {
        long id;
        try {
            id = Long.parseLong(input);
        } catch (NumberFormatException e) {
            communicator.showIllegalInputMessage();
            id = communicator.getId();
        }
        return id;
    }

    @Override
    public Date checkDate(String input) {
        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
        } catch (ParseException e) {
            communicator.showIllegalInputMessage();
            date = communicator.getDate();
        }
        return date;
    }

    @Override
    public double checkAmountOfMoney(String input) {
        double amount;
        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            communicator.showIllegalInputMessage();
            amount = communicator.getAmountOfMoney();
        }
        return amount;
    }

    @Override
    public double checkPercentage(String input) {
        double percent;
        try {
            percent = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            communicator.showIllegalInputMessage();
            percent = communicator.getPercentage();
        }
        return percent / 100;
    }

    @Override
    public Country checkCountry(String input) {
        Country country;
        try {
            country = Country.valueOf(input);
        } catch (IllegalArgumentException e) {
            communicator.showIllegalInputMessage();
            country = communicator.getCountry();
        }
        return country;
    }
}
