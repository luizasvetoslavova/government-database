package citizenData;

import java.util.Date;

public interface IdReader {
    Date getBirthDate(long id);
    Region getBirthRegion(long id);
    Gender getGender(long id);
}
