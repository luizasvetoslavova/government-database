package citizenData;

import java.util.Date;

public class Punishment {
    private Date releaseDate;
    private PunishmentType punishmentType;

    public Punishment(Date releaseDate, PunishmentType punishmentType) {
        this.releaseDate = releaseDate;
        this.punishmentType = punishmentType;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public PunishmentType getPunishmentType() {
        return punishmentType;
    }

    public void setPunishmentType(PunishmentType punishmentType) {
        this.punishmentType = punishmentType;
    }

}
