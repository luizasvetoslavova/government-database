package database.government;

import citizenData.Citizen;
import database.operations.FileEditor;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CitizensDatabase {

    private static CitizensDatabase instance;

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
        fileEditor = FileEditor.getInstance();

        citizensFile = Path.of("src", "database", "government", "Citizens.psv");
    }

    public void add(Citizen citizen) {
        citizens.add(citizen);
        fileEditor.inputData(citizensFile, citizen.toString());
    }

    public Citizen findCitizen(String id) {
        return citizens
                .stream()
                .filter(citizen -> citizen.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }
}
