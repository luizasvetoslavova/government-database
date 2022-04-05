package database.operations;

import citizenData.Citizen;

import java.io.*;
import java.nio.file.Path;

public class FileExtractor implements FileExtraction {

    private static FileExtractor instance;

    public static FileExtractor getInstance() {
        if (instance == null) {
            instance = new FileExtractor();
        }
        return instance;
    }

    private FileExtractor() {

    }

    @Override
    public String extractWholeData(Path path) {
        StringBuilder data = new StringBuilder();

        try {
            InputStream is = new FileInputStream(path.toFile());
            int character = 0;
            do {
                try {
                    character = is.read();
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
    public String extractBankCitizenData(Citizen citizen) {
        StringBuilder data = new StringBuilder();

        data.append("Name: ").append(citizen.getName())
                .append(", ID: ").append(citizen.getId())
                .append(", Companies: ").append(citizen.getCompanies())
                .append(", Credits: ")
                .append(citizen.getCredits())
                .append(", Relatives' credits: ");

        citizen.getRelatives().forEach(relative -> data.append(relative.getCredits()).append("; "));

        return data.toString();
    }

    @Override
    public String extractPoliceCitizenData(Citizen citizen) {
        StringBuilder data = new StringBuilder();

        data.append("Name: ").append(citizen.getName())
                .append(", ID: ").append(citizen.getId())
                .append(", Crimes: ").append(citizen.getCrimes())
                .append(", Possessions: ").append(citizen.getPossessions())
                .append(", Crossing borders: ").append(citizen.getCrossingBorders())
                .append(", Relatives: ");

        citizen.getRelatives().forEach(relative -> data.append(relative.getId()).append("; "));

        return data.toString();
    }
}
