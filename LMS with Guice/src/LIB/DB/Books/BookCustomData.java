package LIB.DB.Books;

import LIB.BOOK.Book;
import LIB.BOOK.Novel;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookCustomData implements DBBooks{
    private List<Book> books;
    public BookCustomData() {
        books = new ArrayList<Book>();
    }

    @Override
    @Inject
    public void update(@Named("BookDB") List<Book> books) {
        this.books=books;
    }

    @Override
    public List<Book> LoadData() {
        return books;
    }
}
