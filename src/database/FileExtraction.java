package database;

import java.io.File;

public interface FileExtraction {
    String extractWholeData(File file);

    String extractEmails(File file);

    String extractPassword(File file, String email);
}
