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

    public static CitizensDatabase getInstance() {
        if (instance == null) {
            instance = new CitizensDatabase();
        }
        return instance;
    }

    private CitizensDatabase() {
        citizens = new HashSet<>();
    }

    public void add(Citizen citizen) {
        citizens.add(citizen);
    }

    public Citizen findCitizen(String id) {
        return citizens
                .stream()
                .filter(citizen -> citizen.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }
}