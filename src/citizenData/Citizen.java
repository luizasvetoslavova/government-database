package citizenData;

import java.util.List;
import java.util.Set;

public class Citizen {
    private String name;
    private String id;
    private String address;
    private Gender gender;

    private List<Punishment> punishments;
    private List<Possession> possessions;
    private List<CrossingBorder> crossingBorders;
    private List<Credit> credits;

    private Set<Citizen> relatives;
    private Set<Company> companies;

    public Citizen(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Punishment> getPunishments() {
        return punishments;
    }

    public void setPunishments(List<Punishment> punishments) {
        this.punishments = punishments;
    }

    public List<Possession> getPossessions() {
        return possessions;
    }

    public void setPossessions(List<Possession> possessions) {
        this.possessions = possessions;
    }

    public List<CrossingBorder> getGoingsAbroad() {
        return crossingBorders;
    }

    public void setGoingsAbroad(List<CrossingBorder> goingsAbroad) {
        this.crossingBorders = goingsAbroad;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public Set<Citizen> getRelatives() {
        return relatives;
    }

    public void setRelatives(Set<Citizen> relatives) {
        this.relatives = relatives;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
