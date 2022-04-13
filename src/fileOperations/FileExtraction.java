package fileOperations;

import citizenData.elements.Citizen;

public interface FileExtraction {
    String extractBankCitizenData(Citizen citizen);
    String extractPoliceCitizenData(Citizen citizen);
}
