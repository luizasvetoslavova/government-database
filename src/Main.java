
import accounts.users.bank.BankClient;
import citizenData.elements.Citizen;
import accounts.users.bank.Bank;

public class Main {
    public static void main(String[] args) {
        new Bank("bank@abv.bg", "12345678", "Mezdra centura", "DSK").getDatabase()
                .add(new BankClient("dided", "jdeid", "kdr984"));
        new Citizen("12", "8439", "djuid");
    }
}
