package database;

import citizenData.elements.Citizen;

import java.util.HashSet;
import java.util.Set;

public class CitizensDatabase extends Database<Citizen> {

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

    @Override
    public String getFileName() {
        return "citizens.database";
    }

    @Override
    public Set<Citizen> getDatabase() {
        return citizens;
    }
}