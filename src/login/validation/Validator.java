package login.validation;

import citizenData.lists.Country;
import login.IO.Communication;
import login.IO.Communicator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator implements Validation {

    private static final Validator instance = new Validator();

    private final Communication communication;

    public static Validator getInstance() {
        return instance;
    }

    private Validator() {
        communication = Communicator.getInstance();
    }

    @Override
    public long checkId(String input) {
        long id;

        try {
            id = Long.parseLong(input);
        } catch (NumberFormatException e) {
            Communicator.getInstance().showIllegalInputMessage();
            id = Communicator.getInstance().getId();
        }

        if (String.valueOf(id).length() != 10) {
            Communicator.getInstance().showIllegalInputMessage();
            id = Communicator.getInstance().getId();
        }
        return id;
    }

    @Override
    public Date checkDate(String input) {
        Date date;

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
        } catch (ParseException e) {
            communication.showIllegalInputMessage();
            date = communication.getDate();
        }
        return date;
    }

    @Override
    public double checkAmountOfMoney(String input) {
        double amount;

        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            communication.showIllegalInputMessage();
            amount = communication.getAmountOfMoney();
        }
        return amount;
    }

    @Override
    public double checkPercentage(String input) {
        double percent;

        try {
            percent = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            communication.showIllegalInputMessage();
            percent = communication.getPercentage();
        }
        return percent / 100;
    }

    @Override
    public Country checkCountry(String input) {
        Country country;

        try {
            country = Country.valueOf(input);
        } catch (IllegalArgumentException e) {
            communication.showIllegalInputMessage();
            country = communication.getCountry();
        }
        return country;
    }
}