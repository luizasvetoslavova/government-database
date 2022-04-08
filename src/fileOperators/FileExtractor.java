package fileOperators;

import citizenData.elements.Citizen;

import java.io.*;

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
    public String extractWholeData(String file) {
        StringBuilder data = new StringBuilder();

        try {
            InputStream is = new FileInputStream(file);
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

        data.append(citizen.bankDataToString());
        citizen.getRelatives().forEach(relative -> data.append(relative.getId()).append("= ")
                .append(relative.getCredits()));

        return data.toString();
    }

    @Override
    public String extractPoliceCitizenData(Citizen citizen) {
        return citizen.policeDataToString();
    }
}
