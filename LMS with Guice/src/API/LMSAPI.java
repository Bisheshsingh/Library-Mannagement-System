package API;

import LIB.BOOK.Book;
import LIB.ORDER.Order;
import LIB.BORROW.Borrow;
import LIB.USER.User;

import java.util.Date;
import java.util.List;

public interface LMSAPI {
    public User Login(int id,String password) throws Exception;
    public void Register(int id,String name,String password) throws Exception;
    public void Add_Book(User admin, Book book) throws Exception;
    public void Update_Book(User admin,Book book) throws Exception;
    public List<Book> GetAllBooks();
    public List<Book> Show_Available_Books();
    public List<Book> Search_Book_By_ID(int id);
    public List<Book> Search_Book_By_Name(String name);
    public List<Book> Search_Book_By_Auhors(List<String> authors);
    public double Calculate_Fine(List<User> users, Date date,double cost);
    public List<Order> View_Order(User admin);
    public boolean Accept_Order(User admin,Order order) throws Exception;
    public boolean Reject_Order(User admin,Order order) throws Exception;
    public boolean Place_Order(User user,Order order) throws Throwable;
    public List<Borrow> View_Borrow(User admin);
    public List<Borrow> SearchBorrowedWithBookID(User admin, int id);
    public List<Borrow> SearchBorrowedWithUserID(User admin,int id);
    public List<Borrow> View_My_Borrow(User user);
}
