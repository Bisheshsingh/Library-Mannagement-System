package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import LIB.BOOK.Book;
import com.google.inject.Guice;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

public class ShowAvailableBooksTest implements Test{
    private LMSAPI api;

    public ShowAvailableBooksTest(){
        this.api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
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
