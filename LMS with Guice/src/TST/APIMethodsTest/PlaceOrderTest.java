package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import API.MSG;
import LIB.ORDER.RequestBook;
import LOG.USER.Admin;
import LOG.USER.Student;
import com.google.inject.Guice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.*;

public class PlaceOrderTest implements Test{
    private LMSAPI api;
    private SimpleDateFormat ft;
    public PlaceOrderTest() {
        this.api = Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
        ft=new SimpleDateFormat ("yyyy-MM-dd");
    }

    private void Check1(){
        System.out.println("\nPlaceOrderTest() Check 1: Invalid Params Initializing...");
        Date st,en;

        try {
            st=ft.parse("2022-01-04");
            en=ft.parse("2022-01-10");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            api.Place_Order(null,
                    new RequestBook(-9999,-124,null,null));
            System.out.println("PlaceOrderTest() Check 1 Failed!");
        } catch (Throwable e) {
            if(e.getMessage().equals(MSG.InvaliParam().getMessage())){
                System.out.println("PlaceOrderTest() Check 1 Passed!");
            }else{
                throw new RuntimeException(e);
            }
        }
    }

    private void Check2() {
        System.out.println("\nPlaceOrderTest() Check 2: Wrong User ID Initializing...");
        Date st,en;

        try {
            st=ft.parse("2022-01-04");
            en=ft.parse("2022-01-10");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            boolean status = api.Place_Order(new Student(123, "Admin"),
                    new RequestBook(123,124,st,en));

            assertFalse(status);
        } catch (Throwable e) {
            if(e.getMessage().equals(MSG.IllegalAccess().getMessage())){
                System.out.println("PlaceOrderTest() Check 2 Passed!");
            }else{
                throw new RuntimeException(e);
            }
        }
    }

    private void Check3(){
        System.out.println("\nPlaceOrderTest() Check 3: Wrong Book ID Initializing...");

        ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date st,en;

        try {
            st=ft.parse("2022-01-04");
            en=ft.parse("2022-01-10");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            boolean status=api.Place_Order(new Student(1234, "Admin"),
                    new RequestBook(1234,978124,st,en));

            assertFalse(status);
        } catch (Throwable e) {
            if(e.getMessage().equals(MSG.ItemDoesNotExist().getMessage())){
                System.out.println("PlaceOrderTest() Check 3 Passed!");
            }else{
                throw new RuntimeException(e);
            }
        }
    }

    private void Check4(){
        System.out.println("\nPlaceOrderTest() Check 4: Book not available Initializing...");

        ft = new SimpleDateFormat ("yyyy-MM-dd");
        Date st,en;

        try {
            st=ft.parse("2022-01-04");
            en=ft.parse("2022-01-10");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            boolean status=api.Place_Order(new Student(124, "Student"),
                    new RequestBook(124,1244778,st,en));

            assertFalse(status);
        } catch (Throwable e) {
            assertTrue(e.getMessage().equals(MSG.ItemDoesNotExist().getMessage()));
            System.out.println("PlaceOrderTest() Check 4 Passed!");
        }
    }


    @Override
    public void run() {
       Check1();
       Check2();
       Check3();
       Check4();
    }
}
