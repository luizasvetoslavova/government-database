package database.government;

import citizenData.Citizen;
import database.operations.FileEditor;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class CitizensDatabase {

    public static CitizensDatabase instance;

    private Set<Citizen> citizens;

    private Path citizensFile;
    private FileEditor fileEditor;

    public static CitizensDatabase getInstance() {
        if (instance == null) {
            instance = new CitizensDatabase();
        }
        return instance;
    }

    private CitizensDatabase() {
        citizens = new HashSet<>();
        fileEditor = new FileEditor();

        citizensFile = Path.of("src", "database", "government", "Citizens.psv");
    }

    public void add(Citizen citizen) {
        citizens.add(citizen);
        fileEditor.inputData(citizensFile, citizen.toString());
    }
}
