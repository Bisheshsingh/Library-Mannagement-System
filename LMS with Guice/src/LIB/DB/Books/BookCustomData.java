package LIB.DB.Books;

import LIB.BOOK.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCustomData implements DBBooks{
    private List<Book> books;
    public BookCustomData() {
        books = new ArrayList<Book>();
    }


    @Override
    public void add(List<Book> books) {
        books.forEach(b -> this.books.add(b));
    }

    @Override
    public void delete(List<Book> books) {
        books.forEach(b -> this.books.remove(b));
    }

    @Override
    public List<Book> LoadData() {
        return books;
    }
}
