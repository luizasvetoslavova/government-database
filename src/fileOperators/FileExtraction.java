package fileOperators;

import citizenData.elements.Citizen;

public interface FileExtraction {
    String extractWholeData(String file);
    String extractBankCitizenData(Citizen citizen);
    String extractPoliceCitizenData(Citizen citizen);
}
