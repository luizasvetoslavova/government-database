import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Path admins = Path.of("src", "database", "accounts",
                "Admins.tsv");

        Reader reader = new FileReader(admins.toFile());

        int character = 0;
        StringBuilder fileText = new StringBuilder();

//        do {
//            try {
//                character = reader.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            fileText.append((char) character);
//        } while (character != -1);

        do {
            try {
                character = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileText.append((char) character);
        } while (character != -1);

        System.out.println(fileText);
    }
}
