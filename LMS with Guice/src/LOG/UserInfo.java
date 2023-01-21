package LOG;

public class UserInfo {
    private int id;
    private String password;
    public UserInfo(int id, String password) {
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
