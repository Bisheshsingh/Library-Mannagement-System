package API;

import FIN.Fine;
import LIB.BOOK.Book;
import LIB.Library;
import LIB.ORDER.Order;
import LOG.AUTH.AdminCheck;
import LOG.AUTH.Authentication;
import LOG.AUTH.Register;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.UserInfo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class LMSAPI {
    private static AdminCheck admincheck;
    private static Library library;
    private static Fine latesubmissionfine;
    private static Authentication logincheck;
    private static Authentication registercheck;

    //-----------------------------------------------------------------------

    public LMSAPI(){
        Injector injector=Guice.createInjector(new APIFactoryClass());
        admincheck=injector.getInstance(AdminCheck.class);//new AdminCheck();
        library=injector.getInstance(Library.class);//new Library_1();
        logincheck=injector.getInstance(Authentication.class);//new Login();
        registercheck=injector.getInstance(Register.class);//new Register();
        latesubmissionfine=injector.getInstance(Fine.class);//new LateSubmission();
    }

    public User Login(int id,String password) throws Exception {
        UserInfo userinfo=new UserInfo(id,password);

        if(!logincheck.Verify(userinfo)){
            throw MSG.IllegalAccess();
        }

        return findUserByID(id);
    }
    public void Register(int id,String name,String password) throws Exception {
        UserInfo userinfo=new UserInfo(id,password);

        if(!registercheck.Verify(userinfo)){
            throw MSG.ItemDoesExist();
        }

        User user=new Student(id,name);
        library.addUser(user);
        library.update();
    }
    public void Add_Book(User admin, Book book) throws Exception {
        if(!admincheck.Verify(admin)){
            throw MSG.IllegalAccess();
        }

        if(!Search_Book_By_ID(book.getID()).isEmpty()){
            throw MSG.ItemDoesExist();
        }

        library.addBook(book);
        library.update();
    }
    public void Update_Book(User admin,Book book) throws Exception {
        if(!admincheck.Verify(admin)){
            throw MSG.IllegalAccess();
        }

        if(Search_Book_By_ID(book.getID()).isEmpty()){
            throw MSG.ItemDoesNotExist();
        }

        library.removeBook(book);
        library.addBook(book);
        library.update();
    }
    public List<Book> GetAllBooks(){
        return library.get_All_Books();
    }
    public List<Book> Show_Available_Books(){
        return library.get_All_Books().stream()
                .filter(book->book.isAvailable())
                .collect(Collectors.toList());
    }
    public List<Book> Search_Book_By_ID(int id){
        return library.get_All_Books().stream()
                .filter(book->book.getID()==id)
                .collect(Collectors.toList());
    }
    public List<Book> Search_Book_By_Name(String name){
        return library.get_All_Books().stream()
                .filter(book->book.getName().startsWith(name))
                .collect(Collectors.toList());
    }
    public List<Book> Search_Book_By_Auhors(List<String> authors){
        return library.get_All_Books().stream()
                .filter(book->{
                    for(String author : book.getAuthors()){
                        if(authors.contains(author)){
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
    public double Calculate_Fine(User admin, List<User> users, Date date,double cost){
         double total_fine = 0.0;
         for(User user : users){
             total_fine += latesubmissionfine.Calculate(user, date, cost);
         }

         return total_fine;
    }
    public List<Order> View_Order(User admin){
        return library.get_Orders();
    }
    public boolean Accept_Order(User admin,Order order) throws Exception {
        if(!admincheck.Verify(admin)){
            throw MSG.IllegalAccess();
        }

        boolean status=true;
        library.ExecuteOrder(order,findUserByID(order.getUserID()),Search_Book_By_ID(order.getBookID()).get(0));
        return status;
    }
    public boolean Reject_Order(User admin,Order order) throws Exception {
        if(!admincheck.Verify(admin)){
            throw MSG.IllegalAccess();
        }

        boolean status=true;

        library.removeOrder(order);

        return status;
    }
    private User findUserByID(int userID){
        List<User> users = library.get_Users().stream()
                .filter(user->user.getID()==userID)
                .collect(Collectors.toList());

        if(users.isEmpty()){
            return null;
        }

        return users.get(0);
    }
    public boolean Place_Order(User user,Order order) throws Exception {
        List<Book> books=Search_Book_By_ID(order.getBookID());

        if(books.isEmpty()){
            throw MSG.ItemDoesNotExist();
        }

        boolean status=true;

        library.addOrder(order);
        library.update();

        return status;
    }
}
