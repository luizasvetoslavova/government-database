package database.operations;

import citizenData.Citizen;

import java.nio.file.Path;
import java.util.List;

public interface FileExtraction {
    String extractWholeData(Path path);
    String extractBankCitizenData(Citizen citizen);
    String extractPoliceCitizenData(Citizen citizen);
}
