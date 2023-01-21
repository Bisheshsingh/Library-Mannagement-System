package LIB;

import LIB.BOOK.Book;
import LIB.ORDER.Order;
import LOG.USER.User;

import java.util.Arrays;
import java.util.List;

public interface Library {
    void addBook(Book book);
    void update();

    void removeBook(Book book);

    List<Book> get_All_Books();

    List<Order> get_Orders();

    List<User> get_Users();

    void addOrder(Order order);

    void removeOrder(Order order);

    void addUser(User user);

    void ExecuteOrder(Order order,User user,Book book);
}
