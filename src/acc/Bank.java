package acc;

public class Bank extends User {
    private String address;
    private String name;
    private String email;
    private String password;

    public Bank(String email, String password, String address, String name) {
        super(email, password);
        this.address = address;
        this.name = name;
    }

    //when saving into citizen data, use that method
    public String bankInfoToString() {
        return "Bank{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    //when saving into 'Users' file, use that method
    public String accountInfoToString() {
        return "Bank{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
