package database;

import java.io.*;

public class FileExtractor implements FileExtraction {

    @Override
    public String extractWholeData(File file) {
        Reader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return extractWholeData(reader);
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

    @Override
    public String extractPassword(File file, String email) {
        return null;
    }

    @Override
    public String extractEmails(File file) {
        return null;
    }
}
