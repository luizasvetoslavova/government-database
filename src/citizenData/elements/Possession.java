package citizenData.elements;

import citizenData.lists.PossessionType;

public class Possession {

    private Citizen owner;
    private PossessionType possessionType;
    private String name;
    private double yearTax;
    private double price;

    public Possession(Citizen owner, PossessionType possessionType, String name, double price) {
        this.owner = owner;
        this.possessionType = possessionType;
        this.name = name;
        this.price = price;
        this.yearTax = price * (0.01 * possessionType.getTaxPercent());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Possession{" +
                "owner=" + owner +
                ", possessionType=" + possessionType +
                ", name='" + name + '\'' +
                ", yearTax=" + yearTax +
                ", price=" + price +
                '}';
    }
}
