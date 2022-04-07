import acc.Bank;
import acc.User;
import citizenData.Citizen;
import database.operations.FileEditor;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Citizen c1 = new Citizen("aziul", "1234443", "iskar 12");
        Citizen c2 = new Citizen("ne znam", "6666", "roza 27");
        Bank user = new Bank("penka", "34", "taka taka", "7984ne");
    }
}
