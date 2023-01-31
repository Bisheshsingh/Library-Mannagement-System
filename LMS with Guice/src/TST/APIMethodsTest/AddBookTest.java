package TST.APIMethodsTest;

import API.LMSAPI;
import LIB.BOOK.Book;
import LIB.BOOK.Novel;
import LIB.USER.Admin;
import LIB.USER.Student;
import com.google.inject.Injector;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;

public class AddBookTest implements Test{
    private LMSAPI api;
    public AddBookTest(Injector injector){
        api = injector.getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nAddBookTest() Check 1: Admin check Initializing...");
        Book book = new Novel(124, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Add_Book(new Student(124, "Student"), book);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("AddBookTest() Check 1 Passed!");
        }
    }

    private void Check2(){
        System.out.println("\nAddBookTest() Check 2: Updated on list or not Initializing...");
        Book book = new Novel(12344, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Add_Book(new Admin(1234, "Admin"), book);
            assertFalse(api.Search_Book_By_ID(12344).isEmpty());
            System.out.println("AddBookTest() Check 2 Passed!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void Check3(){
        System.out.println("\nAddBookTest() Check 3: If Book Already Exists Initializing...");
        Book book = new Novel(12344, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Add_Book(new Admin(1234, "Admin"), book);
            assertFalse(true);
        } catch (Exception e) {
            System.out.println("AddBookTest() Check 3 Passed!");
        }
    }

    private void Check4(){
        System.out.println("\nAddBookTest() Check 4: Invalid Params Initializing...");
        Book book = new Novel(12344, "jfbj", Arrays.asList("as", "er", "fg"));
        try {
            api.Add_Book(new Admin(-1234, "Admin"), book);
            api.Add_Book(new Admin(1234, null), null);
            api.Add_Book(new Admin(1234, "Admin"), new Novel(-12344, null, null));

            assertFalse(true);
        } catch (Exception e) {
            System.out.println("AddBookTest() Check 4 Passed!");
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
