package LIB.INTERFACE;

import LIB.BOOK.Book;
import LIB.BORROW.Borrow;
import LIB.ORDER.Order;
import LIB.USER.User;

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

    List<Borrow> get_Borrows();

    void addBorrow(Borrow borrow);
    void removeBorrow(int bookID);
}
