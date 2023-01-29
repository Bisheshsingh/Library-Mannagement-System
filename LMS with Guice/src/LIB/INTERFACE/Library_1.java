package LIB.INTERFACE;

import LIB.BOOK.Book;
import LIB.BORROW.Borrow;
import LIB.DB.Books.DBBooks;
import LIB.DB.Borrows.DBBorrows;
import LIB.DB.Orders.DBOrders;
import LIB.DB.Users.DBUsers;
import LIB.ORDER.Order;
import LIB.ORDER.RequestBook;
import LIB.ORDER.RequestReturnBook;
import LOG.USER.User;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Arrays;
import java.util.List;

public class Library_1 implements Library {
    private DBBorrows borrowsdb;
    private DBBooks booksdb;
    private DBUsers usersdb;
    private DBOrders ordersdb;

    @Inject
    private Library_1(@Named("CUSTOMBOOKDB") DBBooks dbBooks,
                     @Named("CUSTOMUSERDB") DBUsers dbUsers,
                     @Named("CUSTOMORDERDB") DBOrders dbOrders,
                     @Named("CUSTOMBORROWDB") DBBorrows dbBorrows){

        this.booksdb = dbBooks;
        this.ordersdb = dbOrders;
        this.usersdb = dbUsers;
        this.borrowsdb = dbBorrows;
    }

    @Override
    public void addBook(Book book) {
        this.booksdb.add(Arrays.asList(book));
    }

    @Override
    public void update() {

    }

    @Override
    public void removeBook(Book book) {
        this.booksdb.delete(Arrays.asList(book));
    }

    @Override
    public List<Book> get_All_Books() {
        return this.booksdb.LoadData();
    }

    @Override
    public List<Order> get_Orders() {
        return this.ordersdb.LoadData();
    }

    @Override
    public List<User> get_Users() {
        return this.usersdb.LoadData();
    }

    @Override
    public void addOrder(Order order) {
        ordersdb.add(Arrays.asList(order));
    }

    @Override
    public void removeOrder(Order order) {
       ordersdb.delete(Arrays.asList(order));
    }

    @Override
    public void addUser(User user) {
       usersdb.add(Arrays.asList(user));
    }

    @Override
    public void ExecuteOrder(Order order,User user,Book book) {
        if(order instanceof RequestBook){
            book.Unavailable();
            Borrow borrow=new Borrow(order.getStartDate(),order.getEndDate(),
                    order.getBookID(),user.getID());
            addBorrow(borrow);
        }else if(order instanceof RequestReturnBook){
            book.Available();
            removeBorrow(book.getID());
        }
    }

    @Override
    public void addBorrow(Borrow borrow) {
        this.borrowsdb.add(Arrays.asList(borrow));
    }

    @Override
    public void removeBorrow(int bookID) {
        this.borrowsdb.delete(Arrays.asList(new Borrow(null,null,bookID,0)));
    }

    @Override
    public List<Borrow> get_Borrows() {
        return borrowsdb.LoadData();
    }
}
