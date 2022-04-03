package citizenData;

import citizenData.lists.Country;

import java.util.Date;

public class CrossingBorder {
    private Date date;
    private Country country;
    private boolean isOutOfCountry;

    public CrossingBorder(Date date, Country country, boolean isOutOfCountry) {
        this.date = date;
        this.country = country;
        this.isOutOfCountry = isOutOfCountry;
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
