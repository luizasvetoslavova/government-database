package citizenData.lists;

public enum PossessionType {
    VEHICLE(15), LAND(10), BUILDING(20), FIREARM(5);

    double taxPercent;

    PossessionType(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getTaxPercent() {
        return taxPercent;
    }
}