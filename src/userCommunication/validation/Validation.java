package userCommunication.validation;

import citizenData.lists.Country;

import java.util.Date;

public interface Validation {

    long checkId(String input);

    Date checkDate(String input);

    double checkAmountOfMoney(String input);

    double checkPercentage(String input);

    Country checkCountry(String input);
}
