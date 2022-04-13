package fileOperations;

import citizenData.elements.Citizen;

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
