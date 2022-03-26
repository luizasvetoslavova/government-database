package database.operations;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class FileExtractor implements FileExtraction {

    Path admins = Path.of("src", "database", "accounts",
            "Admins.csv");
    Path organisations = Path.of("src", "database", "accounts", "Organisations.csv");
    Path users = Path.of("src", "database", "accounts", "Users.csv");

    @Override
    public String extractWholeData(Path path) {
        Reader reader = null;
        try {
            reader = new FileReader(path.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return extractWholeData(reader);
    }

    @Override
    public List<String> getEmails(Path path) {
        return null;
    }

    @Override
    public List<String> getPasswords(Path path) {
        return null;
    }

    private String extractWholeData(Reader reader) {
        int character = 0;
        StringBuilder data = new StringBuilder();

        do {
            try {
                character = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            data.append((char) character);
        } while (character != -1);

        return data.toString();
    }


//    List<String> emailsAndPasswords = Arrays.stream(fileText.toString().split("\t")).toList();
//
//    Set<String> emails = new HashSet<>();
//
//        for(int i = 2; i<emailsAndPasswords.size();i++){
//        if (i % 2 != 0) {
//            emails.add(emailsAndPasswords.get(i));
//        }
//    }
//        System.out.println(emails);
//
//    public List<String> getAdminEmails() {
//        Set<String> emails = new HashSet<>();
//
//        for (int i = 2; i < emailsAndPasswords.size(); i++) {
//            if (i % 2 != 0) {
//                emails.add(emailsAndPasswords.get(i));
//            }
//        }
//    }
//
//    public List<String> getOrganisationEmails(Path organisation) {
//
//    }
//
//    public List<String> getUserEmails(Path user) {
//
//    }
}
