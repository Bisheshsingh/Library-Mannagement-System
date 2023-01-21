package LOG.USER;

import java.util.List;
import java.util.stream.Collectors;

public class Student implements User{
    private int id;
    private String name;
    private String password;
    private List<Borrow> borrows;

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

    @Override
    public List<Borrow> getBorrows() {
        return this.borrows;
    }

    @Override
    public void Add_Borrow(Borrow borrow) {
        borrows.add(borrow);
    }

    @Override
    public void Rem_Borrow(int BookID) {
        Borrow borrow=borrows.stream()
                .filter(b->b.getBookID()==BookID)
                .collect(Collectors.toList()).get(0);
        borrows.remove(borrow);
    }
}
