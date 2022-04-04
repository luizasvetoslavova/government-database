package database.operations;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class FileExtractor implements FileExtraction {

    @Override
    public String extractWholeData(Path path) {
        StringBuilder data = new StringBuilder();

        try {
            Reader reader = new FileReader(path.toFile());
            int character = 0;
            do {
                try {
                    character = reader.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data.append((char) character);
            } while (character != -1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

    @Override
    public String extractWholeCitizenData(Path path, String id) {
        List<String> citizens = List.of(extractWholeData(path).split("\r\n"));

        for (int i = 0; i < citizens.size(); i++) {
            if(citizens.get(i).split("|")[1].equals(" id='" + id +"'")) {
                return citizens.get(i);
            }
        }
        return "Citizen not found. \n";
    }

    @Override
    public String extractBankCitizenData() {
        return null;
        //TODO
    }

    @Override
    public String extractPoliceCitizenData() {
        return null;
        //TODO
    }
}
