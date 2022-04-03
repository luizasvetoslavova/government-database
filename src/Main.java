import citizenData.Citizen;
import database.operations.FileEditor;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Citizen c1= new Citizen("pena", "1234443", "iskar 12");
        new FileEditor().inputData(Path.of("src", "database","government","Citizens.psv"), c1.toString());
    }
}
