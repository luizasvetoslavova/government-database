package acc;

public class Police extends User{
    private static Police instance;
    private String password;
    private String email;

    private Police(String email, String password) {
        super(email, password);
        this.email = email;
        this.password = password;
    }

    public static Police getInstance() {
        if(instance == null) {
            instance = new Police();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Police{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
