package database.operations;

import java.nio.file.Path;

public interface FileEditing {
    void inputData(Path path, String input);
    void bankEditCitizenData();
    void policeEditCitizenData();
}
