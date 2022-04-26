package test;

import accounts.Admin;
import accounts.Organisation;
import accounts.users.bank.Bank;
import accounts.users.bank.BankClient;
import citizenData.elements.Citizen;

public class Default {

    public void insertStartupData() {
        insertDefaultAccounts();
        insertDefaultCitizens();
    }

    private void insertDefaultCitizens() {
        new Citizen("Angel Kirilov Maldzhanski", "0546061779", "Vratsa, ul. Todor " +
                "Zhivkov 6");
        new Citizen("Luiza Valerieva Svetoslavova", "0583424739", "Mezdra, ul. " +
                "Adolf Hitler 13");
        new Citizen("Alehandro Harun Mohamed", "9166390234", "Kriva Bara, ul. " +
                "Boiko Borisov 21");
        new Citizen("Ahmet Emir Aslan", "6869325484", "Montana, ul. Vladimir" +
                " Putin 3");
    }

    private void insertDefaultAccounts() {
        new Admin("admin@abv.bg", "admin123");
        new Organisation("org@gmail.com", "org123");
        Bank b1 = new Bank("obb@abv.bg", "1111", "Vratsa, ul. Polkovnik Lukashov 2", "OBB");
        Bank b2 = new Bank("dsk@gmail.com", "1234", "Vratsa, ul. Hristo Botev 44", "DSK");
        new BankClient("Angel Kirilov Maldzhanski", "0546061779", "Vratsa, ul. Todor " +
                "Zhivkov 6", b1);
        new BankClient("Luiza Valerieva Svetoslavova", "0583424739", "Mezdra, ul. " +
                "Adolf Hitler 13", b2);
    }
}