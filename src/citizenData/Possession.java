package citizenData;

import citizenData.lists.PossessionType;

public class Possession {
    private PossessionType possessionType;
    private String name;
    private double taxPercent;
    private double price;

    public Possession(PossessionType possessionType, String name,
                      double taxPercent, double price) {
        this.possessionType = possessionType;
        this.name = name;
        this.taxPercent = taxPercent;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Possession{" +
                "possessionType=" + possessionType +
                ", name='" + name + '\'' +
                ", taxPercent=" + taxPercent +
                ", price=" + price +
                '}';
    }
}
