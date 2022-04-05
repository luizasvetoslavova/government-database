
import citizenData.lists.Gender;
import database.users.Bank;
import database.users.BankClient;

public class Main {
    public static void main(String[] args) {
        new Bank("bank@abv.bg", "12345678", "Mezdra centura", "DSK");
        Bank b = new Bank("obb@gmail.com", "obb098765", "Vratsa probiva", "OBB");
        b.getDatabase().getClients().add(new BankClient("12", "2doed", "ey3hd", Gender.FEMALE));
        b.getDatabase().getClients().get(0).setBalance(23.54);
    }
}
