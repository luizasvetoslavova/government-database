package userCommunication;

import citizenData.*;

import java.util.Date;

public interface Communication {

<<<<<<< HEAD
    String askForEmail();

    String askForPassword();

    Date askForDate();

    PunishmentType askForPunishmentType();

    PossessionType askForPossessionType();

    double askForAmountOfMoney();

    double askForPercentage();

    Country askForCountry();

    void show(String text);

=======
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

>>>>>>> login
    void showAdminOptions();

    void showUserOptions();

    void showOrganisationOptions();
}
