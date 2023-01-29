package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import LIB.ORDER.Order;
import LIB.ORDER.RequestBook;
import LOG.USER.Admin;
import LOG.USER.Student;
import LOG.USER.User;
import com.google.inject.Guice;

import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class AcceptOrderTest implements Test{
    private LMSAPI api;
    public AcceptOrderTest(){
        api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }

    public void Check1(){
        System.out.println("AcceptOrderTest() Check 1: Invalid Params Initializing...");

        try{
            api.Accept_Order(null,null);
            api.Accept_Order(new Student(-123,null),null);
        }catch (InvalidParameterException e){
            System.out.println("AcceptOrderTest() Check 1 Passed!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Check2(){
        System.out.println("AcceptOrderTest() Check 2: Admin Check Initializing...");
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
        try{
            api.Accept_Order(new Admin(123356,"Admin"),
                    new RequestBook(1234,123,
                            ft.parse("2022-03-01"),
                            ft.parse("2022-03-10")
                    ));
        }catch (IllegalAccessException e){
            System.out.println("AcceptOrderTest() Check 2 Passed!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Check3(){
        System.out.println("AcceptOrderTest() Check 3: Accepts Successfully Initializing...");
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
        try{
            User user=new Admin(1234,"Admin");

            Order order=new RequestBook(1234,123,
                    ft.parse("2022-03-01"),
                    ft.parse("2022-03-10")
            );

            api.Place_Order(user,order);

            api.Accept_Order(user,order);

            boolean status=api.View_Order(user).stream()
                    .filter(o -> o.getBookID()==order.getBookID())
                    .collect(Collectors.toList()).isEmpty();

            assertTrue(status);
            System.out.println("AcceptOrderTest() Check 3 Passed!");
        }catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
       Check1();
       Check2();
       Check3();
    }
}
