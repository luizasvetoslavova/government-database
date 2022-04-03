package citizenData;

public class Bank {
    private String address;
    private String name;

    public Bank(String address, String name) {
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
