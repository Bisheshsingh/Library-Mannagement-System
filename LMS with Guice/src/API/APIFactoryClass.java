package API;

import FIN.LateSubmission;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LIB.DB.Books.BookCustomData;
import LIB.DB.Books.DBBooks;
import LIB.DB.Orders.DBOrders;
import LIB.DB.Orders.OrderCustomData;
import LIB.DB.Users.DBUsers;
import LIB.DB.Users.UserCustomData;
import LIB.Library;
import LIB.Library_1;
import FIN.Fine;
import LOG.AUTH.Authentication;
import LOG.AUTH.Login;
import LOG.DB.DBLogin;
import LOG.DB.LoginCustomData;
import LOG.USER.Admin;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.UserInfo;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.util.Arrays;
import java.util.List;

public class APIFactoryClass extends AbstractModule {
    @Override
    protected void configure() {
        super.configure();
        bind(Library.class).to(Library_1.class);
        bind(Fine.class).to(LateSubmission.class);
        bind(Authentication.class).to(Login.class);
        bind(DBLogin.class).to(LoginCustomData.class);
        bind(DBUsers.class).to(UserCustomData.class);
        bind(DBBooks.class).to(BookCustomData.class);
        bind(DBOrders.class).to(OrderCustomData.class);

        bind(new TypeLiteral<List<Book>>() {})
                .annotatedWith(Names.named("BookDB"))
                .toInstance(Arrays.asList(
                        new Novel(123,"HP", Arrays.asList("jkl","lk")),
                        new Novel(126,"KL", Arrays.asList("jxbh","scko")),
                        new Novel(124,"OP", Arrays.asList("jsdsjuh","smk"))
                ));

        bind(new TypeLiteral<List<User>>() {})
                .annotatedWith(Names.named("UserDB"))
                .toInstance(Arrays.asList(
                        new Admin(1234,"Bishesh"),
                        new Student(126,"Mehul"),
                        new Student(124,"Suraj")
                ));

        bind(new TypeLiteral<List<UserInfo>>() {})
                .annotatedWith(Names.named("UserinfoDB"))
                .toInstance(Arrays.asList(
                        new UserInfo(1234,"Admin"),
                        new UserInfo(126,"Student"),
                        new UserInfo(124,"Student")
                ));
    }
}
