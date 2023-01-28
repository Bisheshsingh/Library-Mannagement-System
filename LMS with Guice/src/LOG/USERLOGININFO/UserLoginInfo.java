package LOG.USERLOGININFO;

public class UserLoginInfo {
    private int id;
    private String password;
    public UserLoginInfo(int id, String password) {
        this.id=id;
        this.password=password;
    }

    public int getID() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }
}
