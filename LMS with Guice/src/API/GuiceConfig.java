package API;

import FIN.LateSubmission;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LIB.DB.Books.BookCustomData;
import LIB.DB.Books.BookH2Data;
import LIB.DB.Books.DBBooks;
import LIB.DB.Orders.DBOrders;
import LIB.DB.Orders.OrderCustomData;
import LIB.DB.Orders.OrderH2Data;
import LIB.DB.Users.DBUsers;
import LIB.DB.Users.UserCustomData;
import LIB.DB.Users.UserH2Data;
import LIB.INTERFACE.Library;
import LIB.INTERFACE.Library_1;
import FIN.Fine;
import LOG.AUTH.AdminCheck;
import LOG.AUTH.Authentication;
import LOG.AUTH.LoginCheck;
import LOG.AUTH.RegisterCheck;
import LOG.DB.DBLogin;
import LOG.DB.LoginCustomData;
import LOG.DB.LoginH2Data;
import LOG.USER.Admin;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuiceConfig extends AbstractModule {
    public String ADMINCHECKTOKEN="ADMINCHECK";
    private String LIBRARYTOKEN="LIBRARY_1";
    private String FINETOKEN="LATESUBMISSIONFINE";
    private String LOGINCHECK="LOGINCHECK";
    private String REGISTERCHECK="REGISTERCHECK";
    private String CUSTOMBOOKDB="CUSTOMBOOKDB";
    private String CUSTOMUSERDB="CUSTOMUSERDB";
    private String CUSTOMORDERDB="CUSTOMORDERDB";

    @Override
    protected void configure() {
        super.configure();
        bind(LMSAPI.class).to(LMSAPI_1.class);
        bind(Library.class).annotatedWith(Names.named(LIBRARYTOKEN)).to(Library_1.class);
        bind(Fine.class).annotatedWith(Names.named(FINETOKEN)).to(LateSubmission.class);
        bind(Authentication.class).annotatedWith(Names.named(LOGINCHECK)).to(LoginCheck.class);
        bind(Authentication.class).annotatedWith(Names.named(REGISTERCHECK)).to(RegisterCheck.class);
        bind(Authentication.class).annotatedWith(Names.named(ADMINCHECKTOKEN)).to(AdminCheck.class);

        //DB
        bind(DBLogin.class).to(LoginH2Data.class);
        bind(DBUsers.class).annotatedWith(Names.named(CUSTOMUSERDB)).to(UserH2Data.class);
        bind(DBBooks.class).annotatedWith(Names.named(CUSTOMBOOKDB)).to(BookH2Data.class);
        bind(DBOrders.class).annotatedWith(Names.named(CUSTOMORDERDB)).to(OrderH2Data.class);

        bind(new TypeLiteral<List<Book>>() {})
                .annotatedWith(Names.named("BookDB"))
                .toInstance(new ArrayList<>(Arrays.asList(
                        new Novel(123,"HP", Arrays.asList("jkl","lk")),
                        new Novel(126,"KL", Arrays.asList("jxbh","scko")),
                        new Novel(124,"OP", Arrays.asList("jsdsjuh","smk"))
                )));

        bind(new TypeLiteral<List<User>>() {})
                .annotatedWith(Names.named("UserDB"))
                .toInstance(new ArrayList<>(Arrays.asList(
                        new Admin(1234,"Bishesh"),
                        new Student(126,"Mehul"),
                        new Student(124,"Suraj")
                )));

        bind(new TypeLiteral<List<UserLoginInfo>>() {})
                .annotatedWith(Names.named("UserinfoDB"))
                .toInstance(new ArrayList<>(Arrays.asList(
                        new UserLoginInfo(1234,"Admin"),
                        new UserLoginInfo(126,"Student"),
                        new UserLoginInfo(124,"Student")
                )));
    }
}
