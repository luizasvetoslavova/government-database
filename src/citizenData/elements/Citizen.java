package citizenData.elements;

import accounts.bases.Record;
import citizenData.lists.Gender;
import database.CitizensDatabase;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Citizen extends Record implements Serializable {

    private final String name;
    private final String id;
    private String address;
    private Gender gender;

    private List<Crime> crimes;
    private List<Possession> possessions;
    private List<CrossingBorder> crossingBorders;
    private List<Credit> credits;

    private Set<Citizen> relatives;
    private Set<Company> companies;

    public Citizen(String name, String id, String address) {
        super(id);
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

    public Set<Citizen> getRelatives() {
        return relatives;
    }

    public Gender getGender() {
        return gender;
    }

    public String bankDataToString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", credits=" + credits +
                ", companies=" + companies +
                ", relatives' credits=";
    }

    public String policeDataToString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", crimes=" + crimes +
                ", possessions=" + possessions +
                ", crossingBorders=" + crossingBorders +
                ", relatives=" + relatives +
                '}';
    }
}