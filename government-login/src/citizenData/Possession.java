package citizenData;

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

    public PossessionType getPossessionType() {
        return possessionType;
    }

    public void setPossessionType(PossessionType possessionType) {
        this.possessionType = possessionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
