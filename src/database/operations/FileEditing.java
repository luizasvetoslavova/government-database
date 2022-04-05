package database.operations;

import citizenData.Citizen;

import java.nio.file.Path;

public interface FileEditing {
    void inputData(Path path, String input);
    void replaceData(Path path, String input);
    void editCitizenData(Citizen citizen);
}
