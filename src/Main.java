import java.io.*;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        //test only
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/database/database.accounts/Users.tsv"));
            String text;
            while ((text = br.readLine()) != null) {
                out.println(text);
            }

            br.close();

        } catch (IOException e) {
            out.println("greshka");
        }
    }
}
