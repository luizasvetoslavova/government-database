package userCommunication;

import citizenData.lists.Country;
import citizenData.lists.PossessionType;
import citizenData.lists.PunishmentType;

import java.util.Date;

public interface Communication {

    String getEmail();

    String getPassword();

    Date getDate();

    PunishmentType getPunishmentType();

    PossessionType getPossessionType();

    double getAmountOfMoney();

    double getPercentage();

    long getId();

    Country getCountry();

    void welcome();

    void show(String text);

    void showIllegalInputMessage();

    void showAdminOptions();

    void showUserOptions();

    void showOrganisationOptions();
}
