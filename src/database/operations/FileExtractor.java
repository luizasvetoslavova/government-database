package database.operations;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class FileExtractor implements FileExtraction {

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
}
