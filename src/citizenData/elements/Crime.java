package citizenData.elements;

import citizenData.lists.PunishmentType;

import java.util.Date;

public class Crime {

    private Citizen executant;
    private Date dateOfSentence;
    private PunishmentType punishmentType;

    public Crime(Citizen executant, Date dateOfSentence, PunishmentType punishmentType) {
        this.executant = executant;
        this.dateOfSentence = dateOfSentence;
        this.punishmentType = punishmentType;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "executant=" + executant +
                ", dateOfSentence=" + dateOfSentence +
                ", punishmentType=" + punishmentType +
                '}';
    }
}
