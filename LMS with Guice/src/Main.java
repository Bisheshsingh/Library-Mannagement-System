import API.GuiceConfig;
import API.LMSAPI;
import API.LMSAPI_1;
import DBM.H2DB;
import LIB.BOOK.Novel;
import LIB.DB.Books.BookH2Data;
import LIB.DB.Books.DBBooks;
import LIB.DB.Orders.OrderH2Data;
import LIB.DB.Users.DBUsers;
import LIB.DB.Users.UserH2Data;
import LIB.ORDER.Order;
import LIB.ORDER.RequestBook;
import LOG.DB.DBLogin;
import LOG.DB.LoginH2Data;
import LOG.USER.Admin;
import LOG.USER.Student;
import LOG.USER.User;
import LOG.USERLOGININFO.UserLoginInfo;
import com.google.inject.Guice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import TST.APITest.Tester_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.*;

public class Main {
    @Test
    public void APITesting(){
        Result result = JUnitCore.runClasses(Tester_1.class);
        System.out.println("\n----------------------------------------------\n");

        System.out.println("Test Results : "+(result.wasSuccessful() ? "Passed" : "Failed"));

        if(result.wasSuccessful()){
            System.out.println("\n----------------------------------------------\n");
            return;
        }

        System.out.println("\nFailure Count : "+result.getFailures().size());
        System.out.println("\nFailure Tracks :-\n");

        for (Failure failure : result.getFailures()) {
            System.out.println("Description :"+failure.getDescription());
            System.out.println("Message :"+failure.getMessage());
            System.out.println("Trace :"+failure.getTrace()+"\n\n");
        }

        System.out.println("----------------------------------------------\n");
        throw new RuntimeException("Failed");
    }

    public static void main(String[] args) throws Throwable {
        LMSAPI api=Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
        api.View_Order(new Admin(1234,"Admin")).forEach(x-> System.out.println(x.getUserID()+" "+
                        x.getBookID()+" "+
                        ft.format(x.getStartDate())+" "+
                        ft.format(x.getEndDate())
                ));
    }
}