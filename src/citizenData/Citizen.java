package citizenData;

import citizenData.lists.Gender;
import database.government.CitizensDatabase;

import java.util.List;
import java.util.Set;

public class Citizen {
    private String name;
    private String id;
    private String address;
    private Gender gender;

    private List<Crime> crimes;
    private List<Possession> possessions;
    private List<CrossingBorder> crossingBorders;
    private List<Credit> credits;

    private Set<Citizen> relatives;
    private Set<Company> companies;

    public Citizen(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;

        CitizensDatabase.getInstance().add(this);
    }

    public String getId() {
        return id;
    }

    public List<Possession> getPossessions() {
        return possessions;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                "| id='" + id + '\'' +
                "| address='" + address + '\'' +
                "| gender=" + gender +
                "| punishments=" + crimes +
                "| possessions=" + possessions +
                "| crossingBorders=" + crossingBorders +
                "| credits=" + credits +
                "| relatives=" + relatives +
                "| companies=" + companies +
                '}';
    }
}
