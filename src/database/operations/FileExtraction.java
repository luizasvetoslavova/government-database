package database.operations;

import java.nio.file.Path;
import java.util.List;

public interface FileExtraction {
    String extractWholeData(Path path);
    String extractWholeCitizenData(Path path, String id);
    String extractBankCitizenData();
    String extractPoliceCitizenData();
}
