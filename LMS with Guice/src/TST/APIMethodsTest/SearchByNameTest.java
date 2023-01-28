package TST.APIMethodsTest;

import API.GuiceConfig;
import API.LMSAPI;
import LIB.BOOK.Book;
import com.google.inject.Guice;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchByNameTest implements Test{
    private LMSAPI api;
    public SearchByNameTest(){
        api= Guice.createInjector(new GuiceConfig()).getInstance(LMSAPI.class);
    }

    private void Check1(){
        System.out.println("\nSearchByNameTest() Check 1: Invalid Params");
        List<Book> books = api.Search_Book_By_Name(null);

        assertTrue(books==null || books.isEmpty());
        System.out.println("SearchByNameTest() Check 2 Passed!");
    }

    private void Check2(){
        System.out.println("\nSearchByNameTest() Check 2: Search result validation");

        List<Book> books=api.Search_Book_By_Name("H");

        boolean status=true;
        for(Book book : books){
            status &= book.getName().startsWith("H");
        }

        assertTrue(!books.isEmpty() && status);
        System.out.println("SearchByNameTest() Check 2 Passed!");
    }
    @Override
    public void run() {
        Check1();
        Check2();
    }
}
