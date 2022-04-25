import accounts.Admin;
import login.LoginManager;

public class Main {
    public static void main(String[] args) {
        new Default().insertStartupData();
        LoginManager.getInstance().startLoginProcess();
    }
}
