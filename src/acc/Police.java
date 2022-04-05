package acc;

public class Police extends User{
    private static Police instance;
    private String name;
    private String email;

    public Police(String email, String password) {
        super(email, password);
    }

    public static Police getInstance() {
        if(instance == null) {
            instance = new Police();
        }
        return instance;
    }


    public String accountInfoToString() {
        return "Police{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
