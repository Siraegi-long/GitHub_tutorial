package package1;
public class User {
    private String name;
    private String id;
    private String pw;
    private String phone;
    private String address;
    private boolean loginState;

    public User(String name, String id, String pw, String phone, String address) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
        this.loginState = false;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public boolean isLogin() {
        return loginState;
    }

    public void setLogin(boolean loginState) {
        this.loginState = loginState;
    }
}
