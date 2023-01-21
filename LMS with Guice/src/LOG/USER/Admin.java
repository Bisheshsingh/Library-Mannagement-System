package LOG.USER;

import java.util.List;
import java.util.stream.Collectors;

public class Admin implements User{
    private int id;
    private String name;
    private List<Borrow> borrows;
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

    @Override
    public List<Borrow> getBorrows() {
        return borrows;
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
