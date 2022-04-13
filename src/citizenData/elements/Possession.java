package citizenData.elements;

import citizenData.lists.PossessionType;

public class Possession {

    private Citizen owner;
    private PossessionType possessionType;
    private String id;
    private double yearTax;
    private double price;

    public Possession(Citizen owner, PossessionType possessionType, String id, double price) {
        this.owner = owner;
        this.possessionType = possessionType;
        this.id = id;
        this.price = price;
        this.yearTax = price * (0.01 * possessionType.getTaxPercent());
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Possession{" +
                "owner=" + owner +
                ", possessionType=" + possessionType +
                ", name='" + id + '\'' +
                ", yearTax=" + yearTax +
                ", price=" + price +
                '}';
    }
}
