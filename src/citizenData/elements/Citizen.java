package citizenData.elements;

import accounts.bases.Record;
import citizenData.id.IdReaderImpl;
import citizenData.lists.Gender;
import fileOperations.FileEditor;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Citizen extends Record {

    private static final String fileName = "citizens.database";

    private final String name;
    private final String id;
    private String address;
    private Gender gender;

    private List<Crime> crimes;
    private Map<Long, Possession> possessions;
    private List<CrossingBorder> crossingBorders;
    private List<Credit> credits;

    private Set<Citizen> relatives;
    private Set<Company> companies;

    public Citizen(String name, String id, String address) {
        super(id);
        this.name = name;
        this.id = id;
        this.address = address;
        this.gender = IdReaderImpl.getInstance().getGender(Long.parseLong(id));

        FileEditor.getInstance().inputObject(fileName, this);
    }

    public String getId() {
        return id;
    }

    public Map<Long, Possession> getPossessions() {
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

    public List<Crime> getCrimes() {
        return crimes;
    }

    public List<CrossingBorder> getCrossingBorders() {
        return crossingBorders;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", crimes=" + crimes +
                ", possessions=" + possessions +
                ", crossingBorders=" + crossingBorders +
                ", credits=" + credits +
                ", relatives=" + relatives +
                ", companies=" + companies +
                '}';
    }

    public String privateDataToString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", credits=" + credits +
                ", companies=" + companies +
                ", relatives' credits=";
    }

    public String publicDataToString() {
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