package API;

import FIN.Fine;
import LIB.BOOK.Book;
import LIB.INTERFACE.Library;
import LIB.ORDER.Order;
import LOG.AUTH.Authentication;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
}
