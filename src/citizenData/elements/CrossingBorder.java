package citizenData.elements;

import citizenData.lists.Country;

import java.util.Date;

public class CrossingBorder {

    private final Citizen crossing;
    private final Date date;
    private final Country country;
    private final boolean isOutOfCountry;

    public CrossingBorder(Citizen crossing, Date date, Country country) {
        this.crossing = crossing;
        this.date = date;
        this.country = country;
        isOutOfCountry = !country.equals(Country.BG);
    }

    @Override
    public String toString() {
        return "CrossingBorder{" +
                "date=" + date +
                ", country=" + country +
                ", isOutOfCountry=" + isOutOfCountry +
                '}';
    }
}
