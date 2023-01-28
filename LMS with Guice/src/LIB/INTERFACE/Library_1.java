package LIB.INTERFACE;

import LIB.BOOK.Book;
import LIB.DB.Books.DBBooks;
import LIB.DB.Orders.DBOrders;
import LIB.DB.Users.DBUsers;
import LIB.ORDER.Order;
import LIB.ORDER.RequestBook;
import LIB.ORDER.RequestReturnBook;
import LOG.USER.Borrow;
import LOG.USER.User;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.List;
import java.util.stream.Collectors;

public class Library_1 implements Library {
    private DBBooks booksdb;
    private DBUsers usersdb;
    private DBOrders ordersdb;
    private List<Book> books;
    private List<User> users;
    private List<Order> orders;
    @Inject
    private Library_1(@Named("CUSTOMBOOKDB") DBBooks dbBooks,
                     @Named("CUSTOMUSERDB") DBUsers dbUsers,
                     @Named("CUSTOMORDERDB") DBOrders dbOrders){

        this.booksdb=dbBooks;
        this.ordersdb= dbOrders;
        this.usersdb= dbUsers;

        this.orders=this.ordersdb.LoadData();
        this.users=this.usersdb.LoadData();
        this.books=this.booksdb.LoadData();
    }

    @Override
    public void addBook(Book book) {
        this.books.add(book);
    }

    @Override
    public void update() {
        this.booksdb.update(books);
        this.usersdb.update(users);
        this.ordersdb.update(orders);
    }

    @Override
    public void removeBook(Book book) {
        Book mybook=this.books
                .stream()
                .filter(b->b.getID()==book.getID())
                .collect(Collectors.toList())
                .get(0);

        this.books.remove(mybook);
    }

    @Override
    public List<Book> get_All_Books() {
        return books;
    }

    @Override
    public List<Order> get_Orders() {
        return orders;
    }

    @Override
    public List<User> get_Users() {
        return users;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
       orders.remove(orders.
               stream()
               .filter(order1 -> order1.getBookID()==order.getBookID())
               .collect(Collectors.toList())
               .get(0));
    }

    @Override
    public void addUser(User user) {
       users.add(user);
    }

    @Override
    public void ExecuteOrder(Order order,User user,Book book) {
        if(order instanceof RequestBook){
            book.Unavailable();
            Borrow borrow=new Borrow(order.getStartDate(),order.getEndDate(),order.getBookID());
            user.Add_Borrow(borrow);
        }else if(order instanceof RequestReturnBook){
            book.Available();
            user.Rem_Borrow(order.getBookID());
        }

        this.removeOrder(order);
    }
}
