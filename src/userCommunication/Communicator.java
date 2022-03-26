package userCommunication;

import citizenData.Country;
import citizenData.PossessionType;
import citizenData.PunishmentType;
<<<<<<< HEAD

import java.text.ParseException;
import java.text.SimpleDateFormat;
=======
import userCommunication.validation.Validator;

>>>>>>> login
import java.util.Date;
import java.util.Scanner;

public class Communicator implements Communication {

<<<<<<< HEAD
    Scanner scanner = new Scanner(System.in);

    @Override
    public String askForEmail() {
        String email;
        System.out.print("E-mail: ");

        try {
            email = scanner.nextLine();
        } catch (NullPointerException e) {
            email = askForEmail();
        }
        return email;
    }

    @Override
    public String askForPassword() {
        String password;
        System.out.print("Password: ");

        try {
            password = scanner.nextLine();
        } catch (NullPointerException e) {
            password = askForEmail();
        }
        return password;
    }

    @Override
    public Date askForDate() {
        Date date;
        System.out.print("Date in format DD/MM/YYYY: ");
        String input = scanner.nextLine();

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
        } catch (ParseException e) {
            date = askForDate();
        }
        return date;
    }

    @Override
    public PunishmentType askForPunishmentType() {
=======
    private final Validator validator;
    private final Scanner scanner;

    public Communicator() {
        validator = new Validator();
        scanner = new Scanner(System.in);
    }

    @Override
    public String getEmail() {
        System.out.print("E-mail: ");
        return scanner.nextLine();
    }

    @Override
    public String getPassword() {
        System.out.print("Password: ");
        return scanner.nextLine();
    }

    @Override
    public Date getDate() {
        System.out.print("Date in format DD/MM/YYYY: ");
        return validator.checkDate(scanner.nextLine());
    }

    @Override
    public PunishmentType getPunishmentType() {
>>>>>>> login
        System.out.print("Punishment type: \n" +
                "1. Fining \n" +
                "2. Imprisonment \n" +
                "3. Boarding school \n" +
                "4. Suspended sentence \n" +
                "5. Ban on crossing border \n" +
                "6. House arrest \n" +
                "7. Service work \n" +
                "Your choice: ");

        return switch (scanner.nextLine()) {
            case "1" -> PunishmentType.FINING;
            case "2" -> PunishmentType.IMPRISONMENT;
            case "3" -> PunishmentType.BOARDING_SCHOOL;
            case "4" -> PunishmentType.SUSPENDED_SENTENCE;
            case "5" -> PunishmentType.BAN_ON_CROSSING_BORDER;
            case "6" -> PunishmentType.HOUSE_ARREST;
            case "7" -> PunishmentType.SERVICE_WORK;
<<<<<<< HEAD
            default -> askForPunishmentType();
=======
            default -> getPunishmentType();
>>>>>>> login
        };
    }

    @Override
<<<<<<< HEAD
    public PossessionType askForPossessionType() {
=======
    public PossessionType getPossessionType() {
>>>>>>> login
        System.out.print("Possession types: \n" +
                "1. Vehicle \n" +
                "2. Land \n" +
                "3. Building \n" +
                "4. Firearm \n" +
                "Your choice: ");

        return switch (scanner.nextLine()) {
            case "1" -> PossessionType.VEHICLE;
            case "2" -> PossessionType.LAND;
            case "3" -> PossessionType.BUILDING;
            case "4" -> PossessionType.FIREARM;
<<<<<<< HEAD
            default -> askForPossessionType();
=======
            default -> getPossessionType();
>>>>>>> login
        };
    }

    @Override
<<<<<<< HEAD
    public double askForAmountOfMoney() {
        double amount;
        System.out.println("Amount of money: ");
        String input = scanner.nextLine();

        try {
            amount = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            amount = askForAmountOfMoney();
        }
        return amount;
    }

    @Override
    public double askForPercentage() {
        double percent;
        System.out.println("Percent: ");
        String input = scanner.nextLine();

        try {
            percent = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            percent = askForPercentage();
        }
        return percent / 100;
    }

    @Override
    public Country askForCountry() {
        System.out.println("Country short record (ex. BG):");
//    AD, AE, AF, AG, AI, AL, AM, AN, AO, AQ, AR, AS, AT, AU, AW,
//    AX, AZ, BA, BB, BD, BE, BF, BG, BH, BI, BJ, BM, BN, BO, BR, BS, BT, BV, BW, BY, BZ, CA, CC, CD, CF,
//    CG, CH, CI, CK, CL, CM, CN, CO, CR, CS, CU, CV, CX, CY, CZ, DE, DJ, DK, DM, DO, DZ, EC, EE, EG, EH,
//    ER, ES, ET, FI, FJ, FK, FM, FO, FR, GA, GB, GD, GE, GF, GH, GI, GL, GM, GN, GP, GQ, GR, GS, GT, GU,
//    GW, GY, HK, HM, HN, HR, HT, HU, ID, IE, IL, IN, IO, IQ, IR, IS, IT, JM, JO, JP, KE, KG, KH, KI, KM,
//    KN, KP, KR, KW, KY, KZ, LA, LB, LC, LI, LK, LR, LS, LT, LU, LV, LY, MA, MC, MD, MG, MH, MK, ML, MM,
//    MN, MO, MP, MQ, MR, MS, MT, MU, MV, MW, MX, MY, MZ, NA, NC, NE, NF, NG, NI, NL, NO, NP, NR, NU, NZ,
//    OM, PA, PE, PF, PG, PH, PK, PL, PM, PN, PR, PS, PT, PW, PY, QA, RE, RO, RU, RW, SA, SB, SC, SD, SE,
//    SG, SH, SI, SJ, SK, SL, SM, SN, SO, SR, ST, SV, SY, SZ, TC, TD, TF, TG, TH, TJ, TK, TL, TM, TN, TO,
//    TR, TT, TV, TW, TZ, UA, UG, UM, US, UY, UZ, VA, VC, VE, VG, VI, VN, VU, WF, WS, YE, YT, ZA, ZM, ZW
        //TODO
        return null;
=======
    public double getAmountOfMoney() {
        System.out.println("Amount of money: ");
        return validator.checkAmountOfMoney(scanner.nextLine());
    }

    @Override
    public double getPercentage() {
        System.out.println("Percent: ");
        return validator.checkPercentage(scanner.nextLine());
    }

    @Override
    public long getId() {
        System.out.println("ID: ");
        return validator.checkId(scanner.nextLine());
    }

    @Override
    public Country getCountry() {
        System.out.println("Country short record (ex. BG):");
        return validator.checkCountry(scanner.nextLine().toUpperCase());
>>>>>>> login
    }

    @Override
    public void show(String text) {
        System.out.println(text + "\n");
    }

    @Override
<<<<<<< HEAD
=======
    public void showIllegalInputMessage() {
        System.out.print("Illegal input, please try again: ");
    }

    @Override
>>>>>>> login
    public void showAdminOptions() {
        System.out.print("You logged as an admin. You have control over all organisations. \n" +
                "1. Add data \n" +
                "2. Edit data \n" +
                "3. View data for citizen \n" +
                "4. Create organisation \n" +
                "5. Add user \n" +
                "Your choice: ");
    }

    @Override
    public void showUserOptions() {
        System.out.print("You logged as a user. \n" +
                "1. View data \n" +
                "2. Edit data \n" +
                "Your choice: ");
    }

    @Override
    public void showOrganisationOptions() {
        System.out.println("You logged as an organisation. You can only view all users of yours:");
    }
<<<<<<< HEAD
=======

    @Override
    public void welcome() {
        System.out.println("Welcome to the government database!");
    }

    public Scanner getScanner() {
        return scanner;
    }
>>>>>>> login
}