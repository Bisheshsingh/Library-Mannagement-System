package TST.APIMethodsTest;

import API.LMSAPI;
import LIB.BOOK.Book;
import com.google.inject.Injector;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ShowAvailableBooksTest implements Test{
    private LMSAPI api;

    public ShowAvailableBooksTest(Injector injector){
        this.api = injector.getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nShowAvailableBooksTest() Check 1: Availablity of books Initializing...");
        List<Book> books=api.Show_Available_Books();

        boolean status = true;
        for(Book book : books){
            status &= book.isAvailable();
        }

        assertTrue(status);
        System.out.println("ShowAvailableBooksTest() Check 1 Passed");
    }
    @Override
    public void run() {
       Check1();
    }
}
