package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import LIB.BOOK.Book;
import com.google.inject.Guice;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchByIDTest implements Test{
    private LMSAPI api;
    public SearchByIDTest(){
        api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nSearchByIDTest() Check 1: Invalid Params");
        List<Book> books = api.Search_Book_By_ID(-9999);

        assertTrue(books==null || books.isEmpty());
        System.out.println("SearchByIDTest() Check 2 Passed!");
    }

    private void Check2(){
        System.out.println("\nSearchByIDTest() Check 2: Search result validation");

        List<Book> books=api.Search_Book_By_ID(124);

        assertTrue(books.size()==1 && books.get(0).getID()==124);
        System.out.println("SearchByIDTest() Check 2 Passed!");
    }
    @Override
    public void run() {
       Check1();
       Check2();
    }
}
