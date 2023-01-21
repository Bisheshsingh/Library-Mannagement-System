package LIB.DB.Books;

import LIB.BOOK.Book;
import LOG.USER.User;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

public interface DBBooks {
    void update(List<Book> books);

    List<Book> LoadData();
}
