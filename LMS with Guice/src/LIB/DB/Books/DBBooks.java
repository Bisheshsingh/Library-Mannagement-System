package LIB.DB.Books;

import LIB.BOOK.Book;

import java.util.List;

public interface DBBooks {
    void add(List<Book> books);
    void delete(List<Book> books);
    List<Book> LoadData();
}
