package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LOG.USER.Admin;
import LOG.USER.Student;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UpdateBookTest implements Test{
    private LMSAPI api;

    public UpdateBookTest(){
        this.api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }
    private void Check1(){
        System.out.println("\nUpdateBookTest() Check 1: Admin check Initializing...");
        Book book = new Novel(124, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Update_Book(new Student(124, "Student"), book);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("UpdateBookTest() Check 1 Passed!");
        }
    }

    private void Check2(){
        System.out.println("\nUpdateBookTest() Check 2: if Book doesn't exists Initializing...");
        Book book = new Novel(12466, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Update_Book(new Admin(1234, "Admin"), book);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("UpdateBookTest() Check 2 Passed!");
        }
    }
    private void Check3(){
        System.out.println("\nUpdateBookTest() Check 3: Book updated or not Initializing...");
        Book originalbook=api.Search_Book_By_ID(124).get(0);
        Book modifybook = new Novel(originalbook.getID(), "UT", originalbook.getAuthors());

        try {
            api.Update_Book(new Admin(1234, "Admin"), modifybook);

            Book searchbook=api.Search_Book_By_ID(modifybook.getID()).get(0);

            assertTrue(searchbook.getName().equals(modifybook.getName()));
            System.out.println("UpdateBookTest() Check 3 Passed!");
        } catch (Exception e) {
            System.out.println("UpdateBookTest() Check 3 Failed!");
        }
    }

    private void Check4(){
        System.out.println("\nUpdateBookTest() Check 4: Invalid Params Initializing...");
        Book book = new Novel(12344, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Update_Book(new Admin(-1234, "Admin"), book);
            api.Update_Book(new Admin(1234, null), null);
            api.Update_Book(new Admin(1234, "Admin"), new Novel(-12344, null, null));

            assertFalse(true);
        } catch (Exception e) {
            System.out.println("UpdateBookTest() Check 4 Passed!");
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
