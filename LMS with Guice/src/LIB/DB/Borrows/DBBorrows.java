package LIB.DB.Borrows;

import LIB.BORROW.Borrow;

import java.util.List;

public interface DBBorrows {
    public List<Borrow> LoadData();

    public void add(List<Borrow> borrows);
    public void delete(List<Borrow> borrows);
}
