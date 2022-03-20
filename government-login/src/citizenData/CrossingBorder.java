package citizenData;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isOutOfCountry() {
        return isOutOfCountry;
    }

    public void setOutOfCountry(boolean outOfCountry) {
        isOutOfCountry = outOfCountry;
    }
}
