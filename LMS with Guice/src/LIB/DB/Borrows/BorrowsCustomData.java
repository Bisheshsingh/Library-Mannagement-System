package LIB.DB.Borrows;

import LIB.BORROW.Borrow;

import java.util.ArrayList;
import java.util.List;

public class BorrowsCustomData implements DBBorrows{
    private List<Borrow> borrows;
    public BorrowsCustomData(){
        this.borrows=new ArrayList<>();
    }
    @Override
    public List<Borrow> LoadData() {
        return borrows;
    }

    @Override
    public void add(List<Borrow> borrows) {
       borrows.forEach(this.borrows::add);
    }

    @Override
    public void delete(List<Borrow> borrows) {
        borrows.forEach(this.borrows::remove);
    }
}
