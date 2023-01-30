package LIB.USER;

public class Student implements User{
    private int id;
    private String name;
    private String password;

    public Student(int id, String name) {
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
