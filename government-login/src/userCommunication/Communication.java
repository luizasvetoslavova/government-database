package userCommunication;

import citizenData.*;

import java.util.Date;

public interface Communication {

    String askForEmail();

    String askForPassword();

    Date askForDate();

    PunishmentType askForPunishmentType();

    PossessionType askForPossessionType();

    double askForAmountOfMoney();

    double askForPercentage();

    Country askForCountry();

    void show(String text);

    void showAdminOptions();

    void showUserOptions();

    void showOrganisationOptions();
}
