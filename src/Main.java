import database.operations.FileExtractor;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileExtractor fileExtractor = new FileExtractor();
        Path admins = Path.of("src", "database", "accounts",
                "Admins.csv");
        String data = fileExtractor.extractWholeData(admins);

        List<String> emailsAndPasswords = List.of(data.split("\r\n"));

        for(int i = 1; i < emailsAndPasswords.size(); i++) {
            System.out.println(emailsAndPasswords.get(i).split(",")[1]);
        }
    }
}
