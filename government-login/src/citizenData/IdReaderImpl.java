package citizenData;

import java.util.Date;

public class IdReaderImpl implements IdReader {
    @Override
    public Date getBirthDate(long id) {
        //(id / 10000) - 40     -from 1999
        //(id / 10000) - 20     -before 1900
        //(id / 10000) - 40     -from 1900 to 1999
        return null;
    }

    public boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    @Override
    public Region getBirthRegion(long id) {
        //digit 7-9
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
        return null;
    }
}
