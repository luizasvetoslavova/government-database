package userCommunication;

import citizenData.lists.Country;
import citizenData.lists.Gender;
import citizenData.lists.PossessionType;
import citizenData.lists.PunishmentType;

import java.util.Date;

public interface Communication {

    String getEmail();

    String getPassword();

    String getName();

    String getAddress();

    Date getDate();

    PunishmentType getPunishmentType();

    PossessionType getPossessionType();

    Gender getGender();

    double getAmountOfMoney();

    double getPercentage();

    long getId();

    Country getCountry();

    void welcome();

    void show(String text);

    void showIllegalInputMessage();

    void showAlreadyExistingUserMessage();

    void showAdminOptions();

    void showUserOptions();

    void showOrganisationOptions();

    void showAdminDataAddingOptions();

    void showSuccessfulOperationMessage();

    void showUserTypes();

    void showBankEditingOptions();

    void showPoliceEditingOptions();
}
