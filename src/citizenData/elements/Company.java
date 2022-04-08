package citizenData.elements;

public class Company {

    private Citizen owner;
    private String name;

    public Company(Citizen owner ,String name) {
        this.owner = owner;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
