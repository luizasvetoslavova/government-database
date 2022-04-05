package citizenData;

import citizenData.lists.Gender;
import database.government.CitizensDatabase;
import database.operations.FileEditor;

import java.nio.file.Path;
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

    private Path citizensFile;

    public Citizen(String name, String id, String address, Gender gender) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.gender = gender;

        CitizensDatabase.getInstance().add(this);

        citizensFile = Path.of("src", "database", "government", "Citizens.psv");
        FileEditor.getInstance().inputData(citizensFile, this.toString());

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

    public String getName() {
        return name;
    }

    public Set<Citizen> getRelatives() {
        return relatives;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public List<CrossingBorder> getCrossingBorders() {
        return crossingBorders;
    }

    public String getAddress() {
        return address;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                "|id='" + id + '\'' +
                "|address='" + address + '\'' +
                "|gender=" + gender +
                "|crimes=" + crimes +
                "|possessions=" + possessions +
                "|crossingBorders=" + crossingBorders +
                "|credits=" + credits +
                "|relatives=" + relatives +
                "|companies=" + companies +
                '}';
    }
}
