package citizenData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdReaderImpl implements IdReader {
    @Override
    public Date getBirthDate(long id) {
        Date date = null;

        String year = String.valueOf(getYear(id));
        String month = String.valueOf(getMonthSequence(getMonth(id)));
        String day = String.valueOf(getDay(id));

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/" + year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public Region getBirthRegion(long id) {
        long region = id / 10;
        region = region / 1000;

        if (isBetween((int) region, 0, 38)) {
            return Region.BLAGOEVGRAD;
        } else if (isBetween((int) region, 36, 93)) {
            return Region.BURGAS;
        } else if (isBetween((int) region, 94, 139)) {
            return Region.VARNA;
        } else if (isBetween((int) region, 140, 169)) {
            return Region.VELIKO_TARNOVO;
        } else if (isBetween((int) region, 170, 183)) {
            return Region.VIDIN;
        } else if (isBetween((int) region, 184, 217)) {
            return Region.VRATSA;
        } else if (isBetween((int) region, 218, 233)) {
            return Region.GABROVO;
        } else if (isBetween((int) region, 234, 281)) {
            return Region.KARDZHALI;
        } else if (isBetween((int) region, 282, 301)) {
            return Region.KYUSTENSIL;
        } else if (isBetween((int) region, 302, 319)) {
            return Region.LOVECH;
        } else if (isBetween((int) region, 320, 341)) {
            return Region.MONTANA;
        } else if (isBetween((int) region, 342, 377)) {
            return Region.PAZARZHIK;
        } else if (isBetween((int) region, 378, 395)) {
            return Region.PERNIK;
        } else if (isBetween((int) region, 396, 435)) {
            return Region.PLEVEN;
        } else if (isBetween((int) region, 436, 501)) {
            return Region.PLOVDIV;
        } else if (isBetween((int) region, 502, 527)) {
            return Region.RAZGRAD;
        } else if (isBetween((int) region, 528, 555)) {
            return Region.RUSE;
        } else if (isBetween((int) region, 556, 575)) {
            return Region.SILISTRA;
        } else if (isBetween((int) region, 576, 601)) {
            return Region.SLIVEN;
        } else if (isBetween((int) region, 602, 623)) {
            return Region.SMOLYAN;
        } else if (isBetween((int) region, 624, 721)) {
            return Region.SOFIA_TOWN;
        } else if (isBetween((int) region, 722, 751)) {
            return Region.SOFIA_REGION;
        } else if (isBetween((int) region, 752, 789)) {
            return Region.STARA_ZAGORA;
        } else if (isBetween((int) region, 790, 821)) {
            return Region.DOBRICH;
        } else if (isBetween((int) region, 822, 843)) {
            return Region.TARGOVISHTE;
        } else if (isBetween((int) region, 844, 871)) {
            return Region.HASKOVO;
        } else if (isBetween((int) region, 872, 903)) {
            return Region.SHUMEN;
        } else if (isBetween((int) region, 904, 925)) {
            return Region.YAMBOL;
        }
        return Region.UNKNOWN;
    }

    @Override
    public Gender getGender(long id) {

        if (((id / 10) / 1000) % 2 == 0) {
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }

    public long getMonthSequence(long monthIndex) {
        if (monthIndex >= 41) {
            monthIndex -= 40;
        } else if (monthIndex >= 21 && monthIndex <= 32) {
            monthIndex -= 20;
        }

        return monthIndex;
    }

    public long getMonth(long id) {
        return (id / 1000000) % 100;
    }

    public long getDay(long id) {
        return (id / 10000) % 100;
    }

    public long getYear(long id) {
        return id / 100000000;
    }

    public boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
