package LIB.USER;

public class Admin implements User{
    private int id;
    private String name;
    public Admin(int id, String name) {
        this.id=id;
        this.name=name;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
