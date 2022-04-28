package login.validation;

import citizenData.lists.Country;
import login.IO.Communication;
import login.IO.Communicator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator implements Validation {

    private static final Validator instance = new Validator();

    public static Validator getInstance() {
        return instance;
    }

    private Validator() {

    }

    @Override
    public String checkEmail(String email) {
        if (isEmpty(email) || !email.matches("^[\\w!#$%&’+/=?`{|}~^-]+(?:\\.[\\w!#$%&’+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            Communicator.getInstance().showIllegalInputMessage();
            email = Communicator.getInstance().getEmail();
        }
        return email;
    }

    @Override
    public String checkPassword(String password) {
        if(isEmpty(password) || password.length() < 8){
            Communicator.getInstance().showIllegalInputMessage();
            password = Communicator.getInstance().getPassword();
        }
        return password;
    }

    @Override
    public String checkName(String name) {
        if (isEmpty(name)){
            Communicator.getInstance().showIllegalInputMessage();
            name = Communicator.getInstance().getName();
        }
        return name;
    }

    @Override
    public String checkAddress(String address) {
        if (isEmpty(address)){
            Communicator.getInstance().showIllegalInputMessage();
            address = Communicator.getInstance().getAddress();
        }
        return address;
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

        if (isEmpty(input)) {
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
            Communicator.getInstance().showIllegalInputMessage();
            date = Communicator.getInstance().getDate();
        }

        if(isEmpty(input)){
            Communicator.getInstance().showIllegalInputMessage();
            date = Communicator.getInstance().getDate();
        }

        if (date == null) {
            Communicator.getInstance().showIllegalInputMessage();
            date = Communicator.getInstance().getDate();
        }
        return date;
    }

    @Override
    public double checkAmountOfMoney(String input) {
        double amount;

        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            Communicator.getInstance().showIllegalInputMessage();
            amount = Communicator.getInstance().getAmountOfMoney();
        }

        if(isEmpty(input)){
            Communicator.getInstance().showIllegalInputMessage();
            amount = Communicator.getInstance().getAmountOfMoney();
        }

        return amount;
    }

    @Override
    public double checkPercentage(String input) {
        double percent;

        try {
            percent = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            Communicator.getInstance().showIllegalInputMessage();
            percent = Communicator.getInstance().getPercentage();
        }

        if(isEmpty(input)){
            Communicator.getInstance().showIllegalInputMessage();
            percent = Communicator.getInstance().getPercentage();
        }
        return percent / 100;
    }

    @Override
    public Country checkCountry(String input) {
        Country country;

        try {
            country = Country.valueOf(input);
        } catch (IllegalArgumentException e) {
            Communicator.getInstance().showIllegalInputMessage();
            country = Communicator.getInstance().getCountry();
        }

        if(isEmpty(input)){
            Communicator.getInstance().showIllegalInputMessage();
            country = Communicator.getInstance().getCountry();
        }
        return country;
    }

    public boolean isEmpty(String input){
        return input == null || input.isBlank();
    }
}