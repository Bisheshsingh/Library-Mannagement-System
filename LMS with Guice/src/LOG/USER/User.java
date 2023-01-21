package LOG.USER;

import java.util.List;

public interface User {
    int getID();
    String getName();
    List<Borrow> getBorrows();
    void Add_Borrow(Borrow borrow);
    void Rem_Borrow(int BookID);
}
