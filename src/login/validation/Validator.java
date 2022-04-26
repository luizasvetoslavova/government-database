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
    public String checkEmail(String email) {
        if (isEmpty(email) || !email.matches("^[\\w!#$%&’+/=?`{|}~^-]+(?:\\.[\\w!#$%&’+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")){
            communication.showIllegalInputMessage();
            email = communication.getEmail();
        }
        return email;
    }

    @Override
    public String checkPassword(String password) {
        if(isEmpty(password) || password.length() > 8){
            communication.showIllegalInputMessage();
            password = communication.getPassword();
        }
        return password;
    }

    @Override
    public String checkName(String name) {
        if (isEmpty(name)){
            communication.showIllegalInputMessage();
            name = communication.getName();
        }
        return name;
    }

    @Override
    public String checkAddress(String address) {
        if (isEmpty(address)){
            communication.showIllegalInputMessage();
            address = communication.getAddress();
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
            communication.showIllegalInputMessage();
            date = communication.getDate();
        }

        if(isEmpty(input)){
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

        if(isEmpty(input)){
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

        if(isEmpty(input)){
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

        if(isEmpty(input)){
            communication.showIllegalInputMessage();
            country = communication.getCountry();
        }
        return country;
    }

    public boolean isEmpty(String input){
        return input == null || input.isBlank();
    }
}