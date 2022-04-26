package login.validation;

import citizenData.lists.Country;

import java.util.Date;

public interface Validation {
    String checkEmail(String email);

    String checkPassword(String password);

    String checkName(String name);

    String checkAddress(String address);

    String checkEmail(String email);

    String checkPassword(String password);

    String checkName(String name);

    String checkAddress(String address);

    long checkId(String input);

    Date checkDate(String input);

    double checkAmountOfMoney(String input);

    double checkPercentage(String input);

    Country checkCountry(String input);
}
