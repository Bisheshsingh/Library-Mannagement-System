import API.APIFactoryClass;
import API.LMSAPI;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LIB.DB.Books.BookCustomData;
import LIB.DB.Books.DBBooks;
import LOG.AUTH.Register;
import LOG.DB.LoginCustomData;
import LOG.USER.Admin;
import LOG.USER.User;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        LMSAPI api = new LMSAPI();

        api.GetAllBooks().forEach(
                book -> System.out.println(book.getName())
        );


    }
}