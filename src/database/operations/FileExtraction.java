package database.operations;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface FileExtraction {

    String extractWholeData(Path path);

    List<String> getEmails(Path path);

    List<String> getPasswords(Path path);
}
