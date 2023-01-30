package API;

import FIN.FINE.Fine;
import LIB.BOOK.Book;
import LIB.INTERFACE.Library;
import LIB.ORDER.Order;
import LOG.AUTH.Authentication;
import LIB.BORROW.Borrow;
import LIB.USER.Student;
import LIB.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LMSAPI_1 implements LMSAPI{
    private Authentication admincheck;
    public Library library;
    private Fine latesubmissionfine;
    private Authentication logincheck;
    private Authentication registercheck;
    @Inject
    private LMSAPI_1(@Named("ADMINCHECK") Authentication admincheck,
                   @Named("LIBRARY_1") Library library,
                   @Named("LATESUBMISSIONFINE") Fine latesubmissionfine,
                   @Named("LOGINCHECK") Authentication logincheck,
                   @Named("REGISTERCHECK") Authentication registercheck) {

        this.admincheck = admincheck;
        this.library = library;
        this.latesubmissionfine = latesubmissionfine;
        this.logincheck = logincheck;
        this.registercheck = registercheck;
    }

    //-----------------------------------------------------------------------
    @Override
    public User Login(int id, String password) throws IllegalAccessException {
        UserLoginInfo userinfo=new UserLoginInfo(id,password);

        if(!logincheck.Verify(userinfo)){
            throw MSG.IllegalAccess();
        }

        return findUserByID(id);
    }
    @Override
    public void Register(int id,String name,String password) throws Exception {
        if(name==null || password==null || id<=0){
            throw MSG.InvaliParam();
        }

        UserLoginInfo userinfo=new UserLoginInfo(id,password);

        if(!registercheck.Verify(userinfo)){
            throw MSG.ItemDoesExist();
        }

        User user=new Student(id,name);
        library.addUser(user);
        library.update();
    }
    @Override
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
    @Override
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
    @Override
    public List<Book> GetAllBooks(){
        return library.get_All_Books();
    }
    @Override
    public List<Book> Show_Available_Books(){
        return GetAllBooks().stream()
                .filter(book->book.isAvailable())
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> Search_Book_By_ID(int id){
        return GetAllBooks().stream()
                .filter(book -> book.getID() == id)
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> Search_Book_By_Name(String name) {
        if(name==null){
            return null;
        }
        return GetAllBooks().stream()
                .filter(book->book.getName().startsWith(name))
                .collect(Collectors.toList());
    }
    @Override
    public List<Book> Search_Book_By_Auhors(List<String> authors){
        if(authors==null){
            return null;
        }

        return GetAllBooks().stream()
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
    @Override
    public double Calculate_Fine(List<User> users, Date date, double cost){
        double total_fine = 0.0;
        for(User user : users){
            total_fine += latesubmissionfine.Calculate(user, date, cost);
        }

        return total_fine;
    }
    @Override
    public List<Order> View_Order(User admin){
        return library.get_Orders();
    }
    @Override
    public boolean Accept_Order(User admin,Order order) throws Exception {
        if(admin==null || order==null){
            throw MSG.InvaliParam();
        }

        if(!admincheck.Verify(admin)){
            throw MSG.IllegalAccess();
        }

        boolean status=true;
        library.ExecuteOrder(order,findUserByID(order.getUserID()),Search_Book_By_ID(order.getBookID()).get(0));
        library.removeOrder(order);
        library.update();
        return status;
    }
    @Override
    public boolean Reject_Order(User admin,Order order) throws Exception {
        if(!admincheck.Verify(admin)){
            throw MSG.IllegalAccess();
        }

        boolean status=true;

        library.removeOrder(order);
        library.update();

        return status;
    }

    private User findUserByID(int userID){
        List<User> users = library.get_Users().stream()
                .filter(user->user.getID()==userID)
                .collect(Collectors.toList());

        return users.isEmpty() ? null : users.get(0);
    }
    @Override
    public boolean Place_Order(User user, Order order) throws Exception {
        if(user==null || order==null){
            throw MSG.InvaliParam();
        }

        List<Book> books=Search_Book_By_ID(order.getBookID());

        if(findUserByID(user.getID())==null){
            throw MSG.IllegalAccess();
        }

        if(books.isEmpty() || !books.get(0).isAvailable()){
            throw MSG.ItemDoesNotExist();
        }

        boolean status=true;

        library.addOrder(order);
        library.update();

        return status;
    }
    @Override
    public List<Borrow> View_Borrow(User admin) {
        return library.get_Borrows();
    }
    @Override
    public List<Borrow> SearchBorrowedWithBookID(User admin,int id) {
        return View_Borrow(admin).stream()
                .filter(b -> b.getBookID()==id)
                .collect(Collectors.toList());
    }
    @Override
    public List<Borrow> SearchBorrowedWithUserID(User admin,int id) {
        return View_Borrow(admin).stream()
                .filter(b -> b.getUserID()==id)
                .collect(Collectors.toList());
    }
}
